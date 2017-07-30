(ns yo.slack.usergroups.users
  (:require [yo.slack.core :as slack])
  (:refer-clojure :exclude [list update]))

(defn list
  "This method returns a list of all users within a User Group.

  Required arguments are:
  * token -- Authentication token
  * usergroup -- The encoded ID of the User Group

  Options keywords are:
  * :include_disabled -- Allow results that involve disabled User Groups."
  ([token usergroup]
   (list token usergroup {}))
  ([token usergroup opts]
   (slack/request-get "usergroups.users.list" (conj opts {:token token :usergroup usergroup}))))

(defn update
  "This method updates the list of users that belong to a User Group.

  Required arguments are:
  * token -- Authentication token
  * usergroup -- The encoded ID of the User Group to update
  * users -- A comma separated string of encoded user IDs that represent the entire list of users for the User Group

  Options keywords are:
  * :include_count -- Include the number of users in the User Group."
  ([token usergroup users]
   (update token usergroup users {}))
  ([token usergroup users opts]
   (slack/request-get "usergroups.users.update"
                      (conj opts {:token token :usergroup usergroup :users users}))))
