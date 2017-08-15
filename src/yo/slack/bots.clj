(ns yo.slack.bots
  (:require [yo.slack.core :as slack]))

(defn info
  "This method returns information about a bot user.

  Required arguments are:
  * token -- Authentication token

  Options keywords are:
  * :bot -- Bot user to get info on"
  ([token]
   (info token {}))
  ([token opts]
   (slack/request-get "bots.info" (conj opts {:token token}))))
