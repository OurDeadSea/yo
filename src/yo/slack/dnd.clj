(ns yo.slack.dnd
  (:require [yo.slack.core :as slack]))

(defn end-dnd
  "Ends the user's currently scheduled Do Not Disturb session immediately.

  Required arguments are:
  * token -- Authentication token"
  [token]
  (slack/request-get "dnd.endDnd" {:token token}))

(defn end-snooze
  "Ends the current user's snooze mode immediately.

  Required arguments are:
  * token -- Authentication token"
  [token]
  (slack/request-get "dnd.endSnooze" {:token token}))

(defn info
  "Provides information about a user's current Do Not Disturb settings.

  Required arguments are:
  * token -- Authentication token
  
  Options keywords are:
  * :user -- User to fetch status for (defaults to current user)"
  ([token]
   (info token {}))
  ([token opts]
   (slack/request-get "dnd.info" (conj opts {:token token}))))

(defn set-snooze
  "Adjusts the snooze duration for a user's Do Not Disturb settings.

  Required arguments are:
  * token -- Authentication token
  * num-minutes -- Number of minutes, from now, to snooze until"
  [token num-minutes]
  (slack/request-get "dnd.setSnooze" {:token token :num_minutes num-minutes}))

(defn team-info
  "Provides information about the current Do Not Disturb settings for users of a Slack team.

  Required arguments are:
  * token -- Authentication token
  
  Options keywords are:
  * :users -- Comma-separated list of users to fetch Do Not Disturb status for"
  ([token]
   (team-info token {}))
  ([token opts]
   (slack/request-get "dnd.teamInfo" (conj opts {:token token}))))
