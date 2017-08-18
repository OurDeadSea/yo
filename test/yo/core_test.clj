(ns yo.core-test
  (:require [clojure.test :refer :all]
            [yo.core :refer :all]))

(deftest main-test
  (testing "The main procedure should always return nil"
    (is (= (-main) nil))))
