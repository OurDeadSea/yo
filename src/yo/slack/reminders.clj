(ns yo.slack.reminders)

(defn add
  "This method creates a reminder.

  Required arguments are:
  * token -- Authentication token
  * text -- The content of the reminder
  * time -- When this reminder should happen

  Options arguments are:
  * :user -- The user who will receive the reminder."
  ([token text time]
   (add token text time {}))
  ([token text time opts]
   :TODO))

(defn complete
  "This method completes a reminder.

  Required arguments are:
  * token -- Authentication token
  * reminder -- The ID of the reminder to be marked as complete."
  [token reminder]
  :TODO)

(defn delete
  "This method deletes a reminder.

  Required arguments are:
  * token -- Authentication token
  * reminder -- The ID of the reminder."
  [token reminder]
  :TODO)

(defn info
  "This method returns information about a reminder.

  Required arguments are:
  * token -- Authentication token
  * reminder -- The ID of the reminder."
  [token reminder]
  :TODO)

(defn list
  "This method lists all reminders created by or for a given user.

  Required arguments are:
  * token -- Authentication token."
  [token]
  :TODO)


