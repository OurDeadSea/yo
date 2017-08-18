(ns yo.slack.api-test
  (:require [clojure.test :refer :all]
            [yo.slack.api :as api]
            [yo.slack.errors :as errors]))

(deftest test-method-test
  (testing "The Slack api.test method"
    (testing "Valid calls"
      (is (= (api/test)
             {:ok true}))
      (is (= (api/test {:foo "bar"})
             {:ok true :args {:foo "bar"}}))
      (is (= (api/test {:error "my_error"})
             {:ok false :error "my_error"
              :args {:error "my_error"}}))
      (is (= (api/test {:bar "foo"})
             {:ok true :args {:bar "foo"}})))
    (testing "Invalid calls"
      (is (= (api/test {:*** "bar"})
             {:ok false :error errors/invalid-arg-name}))
      (is (= (api/test {"foo[7]" "bar"})
             {:ok false :error errors/invalid-array-arg})))))
