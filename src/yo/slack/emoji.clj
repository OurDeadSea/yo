(ns yo.slack.emoji
  (:require [yo.slack.core :as slack])
  (:refer-clojure :exclude [list]))

(defn list
  "This method lists the custom emoji for a team.

  Required arguments are:
  * token -- Authentication token"
  [token]
  (slack/request-get "emoji.list" {:token token}))
