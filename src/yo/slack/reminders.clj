(ns yo.slack.reminders
  (:require [yo.slack.core :as slack])
  (:refer-clojure :exclude [list]))

(defn add
  "This method creates a reminder.

  Required arguments are:
  * token -- Authentication token
  * text -- The content of the reminder
  * time -- When this reminder should happen

  Options keywords are:
  * :user -- The user who will receive the reminder."
  ([token text time]
   (add token text time {}))
  ([token text time opts]
   (slack/request-get "reminders.add" (conj opts {:token token :text text :time time}))))

(defn complete
  "This method completes a reminder.

  Required arguments are:
  * token -- Authentication token
  * reminder -- The ID of the reminder to be marked as complete."
  [token reminder]
  (slack/request-get "reminders.complete" {:token token :reminder reminder}))

(defn delete
  "This method deletes a reminder.

  Required arguments are:
  * token -- Authentication token
  * reminder -- The ID of the reminder."
  [token reminder]
  (slack/request-get "reminders.delete" {:token token :reminder reminder}))

(defn info
  "This method returns information about a reminder.

  Required arguments are:
  * token -- Authentication token
  * reminder -- The ID of the reminder."
  [token reminder]
  (slack/request-get "reminders.info" {:token token :reminder reminder}))

(defn list
  "This method lists all reminders created by or for a given user.

  Required arguments are:
  * token -- Authentication token."
  [token]
  (slack/request-get "reminders.list" {:token token}))
