(ns yo.slack.usergroups
  (:require [yo.slack.core :as slack])
  (:refer-clojure :exclude [list update]))

(defn create
  "This method is used to create a User Group.

  Required arguments are:
  * token -- Authentication token
  * name -- A name for the User Group

  Optioons keywords are:
  * :channels -- A comma separated string of encoded channel IDs for which the User Group uses as a default
  * :description -- A short description of the User Group
  * :handle -- A mention handle
  * :include_count -- Include the number of users in each User Group."
  ([token name]
   (create token name {}))
  ([token name opts]
   (slack/request-get "usergroups.create" (conj opts {:token token :name name}))))

(defn disable
  "This method disables an existing User Group.

  Required arguments are:
  * token -- Authentication token
  * usergroup -- The encoded ID of the User Group to disable

  Options keywords are:
  * :include_count -- Include the number of users in the User Group."
  ([token usergroup]
   (disable token usergroup {}))
  ([token usergroup opts]
   (slack/request-get "usergroups.disable" (conj opts {:token token :usergroup usergroup}))))

(defn enable
  "This method enables a User Group wich was previously disabled.

  Required arguments are:
  * token -- Authentication token
  * usergroup -- The encoded ID of the User Group to enable

  Options keywords are:
  * :include_count -- Include the number of users in the User Group."
  ([token usergroup]
   (enable token usergroup {}))
  ([token usergroup opts]
   (slack/request-get "usergroups.enable" (conj opts {:token token :usergroup usergroup}))))

(defn list
  "This method returns a list of all User Groups in the team. This can optionally include disabled User Groups.

  Required arguments are:
  * token -- Authentication token

  Options keywords are:
  * :include_count -- Include the number of users in each User Groups
  * :include_disabled -- Include disabled User Groups
  * :include_users -- Include the list of users for each User Group."
  ([token]
   (list token {}))
  ([token opts]
   (slack/request-get "usergroups.list" (conj opts {:token token}))))

(defn update
  "This method updates the properties of an existing User Group.

  Required arguments are:
  * token -- Authentication token
  * usergroup -- The encoded ID of the User Group

  Options keywords are:
  * :channels -- A comma separated string of encoded channel IDs for which the User Group uses as a default
  * :description -- A short description of the User Group
  * :handle -- A mention handle
  * :include_count -- Include the number of users in the User Group
  * :name -- A name for the User Group."
  ([token usergroup]
   (update token usergroup {}))
  ([token usergroup opts]
   (slack/request-get "usergroups.update" (conj opts {:token token :usergroup usergroup}))))
