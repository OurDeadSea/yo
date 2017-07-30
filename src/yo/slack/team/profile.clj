(ns yo.slack.team.profile
  (:require [yo.slack.core :as slack])
  (:refer-clojure :exclude [get]))

(defn get
  "This method is used to get the profile field definitions for this team

  Required arguments are:
  * token -- Authentication token

  Options keywords are:
  * :visibility -- Filter by visibility."
  ([token]
   (get token {}))
  ([token opts]
   (slack/request-get "team.profile.get" (conj opts {:token token}))))
