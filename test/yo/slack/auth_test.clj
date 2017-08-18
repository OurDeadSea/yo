(ns yo.slack.auth-test
  (:require [clojure.test :refer :all]
            [yo.slack.auth :as auth]
            [yo.slack.errors :as errors]
            [environ.core :refer [env]]))

(def user-token (env :oauth-token))
(def bot-token (env :bot-oauth-token))

(deftest revoke-method-test
  (testing "The Slack auth.revoke method"
    (testing "Valid calls"
      (is (= (auth/revoke user-token {:test true})
             {:ok true
              :revoked false})))
    (testing "Invalid calls"
      (is (= (auth/revoke bot-token {:test true})
             {:ok false
              :error errors/not-allowed-token-type}))
      (is (= (auth/revoke "" {:test true})
             {:ok false
              :error errors/not-authed})))))

(deftest test-method-test
  (testing "The Slack auth.test method"
    (testing "Valid calls"
      (let [user-resp (auth/test user-token)
            bot-resp  (auth/test bot-token)]
        (is (and (:ok user-resp)
                 (= (set (keys user-resp))
                    #{:ok :url :team :user :team_id :user_id})))
        (is (and (:ok bot-resp)
                 (= (set (keys bot-resp))
                    #{:ok :url :team :user :team_id :user_id})))))
    (testing "Invalid calls"
      (is (= (auth/test "")
             {:ok false
              :error errors/not-authed}))
      (is (= (auth/test "this-is-no-token")
             {:ok false
              :error errors/invalid-auth})))))
