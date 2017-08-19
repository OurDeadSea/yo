(ns yo.slack.bots-test
  (:require [clojure.test :refer :all]
            [yo.slack.bots :as bots]
            [yo.slack.errors :as errors]
            [environ.core :refer [env]]))

(def user-token (env :oauth-token))
(def bot-token (env :bot-oauth-token))

(deftest info-method-test
  (testing "The Slack bots.info method"
    (testing "Valid calls"
      (is (= (bots/info user-token)
             (bots/info user-token {:bot ""})
             {:ok true})))
    (testing "Invalid calls"
      (is (= (bots/info user-token {:bot "not-a-bot"})
             {:ok false :error errors/bot-not-found}))
      (is (= (bots/info bot-token)
             (bots/info bot-token {:bot ""})
             {:ok false :error errors/user-is-bot})))))
