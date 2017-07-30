(ns yo.slack.users.profile
  (:require [yo.slack.core :as slack])
  (:refer-clojure :exclude [get set]))

(defn get
  "Use this method to retrieve a user's profile information.

  Required arguments are:
  * token -- Authentication token

  Options keywords are:
  * :include_labels -- Include labels for each ID in custom profile fields
  * :user -- User to retrieve profile info for."
  ([token]
   (get token {}))
  ([token opts]
   (slack/request-get "users.profile.get" (conj opts {:token token}))))

(defn set
  "Use this method to set a user's profile information, including name, email, current status, and other attributes.

  Required arguments are:
  * token -- Authentication token

  Options keywords are:
  * :name -- Name of a single key to set
  * :profile -- Collection of key:value pairs presented as a URL-encoded JSON hash
  * :user -- ID of user to change
  * :value -- Value to set a single key to."
  ([token]
   (set token {}))
  ([token opts]
   (slack/request-get "users.profile.set" (conj opts {:token token}))))
