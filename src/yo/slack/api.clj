(ns yo.slack.api
  (:require [yo.slack.core :as slack])
  (:refer-clojure :exclude [test]))

(defn test
  "This method helps you test your calling code.

  Options keywords are:
  * :error -- Error response to return
  * :foo -- Example property to return"
  ([]
   (test {}))
  ([opts]
   (slack/request-get "api.test" opts)))
