(ns yo.slack.users
  (:require [yo.slack.core :as slack])
  (:refer-clojure :exclude [identity list]))

(defn delete-photo
  "This method allows the user to delete their profile image. It will clear whatever image is currently set.

  Required arguments are:
  * token -- Authentication token."
  [token]
  (slack/request-get "users.deletePhoto" {:token token}))

(defn get-presence
  "This method lets you find out information about a user's presence.

  Required arguments are:
  * token -- Authentication token
  * user -- User to get presence info on."
  [token user]
  (slack/request-get "users.getPresence" {:token token :user user}))

(defn identity
  "After your Slack app is awarded an identity token through Sign in with Slack, use this method to retrieve a user's identity.

  Required arguments are:
  * token -- Authentication token."
  [token]
  (slack/request-get "users.identity" {:token token}))

(defn info
  "This method returns information about a team member.

  Required arguments are:
  * token -- Authentication token
  * user -- User to get info on"
  [token user]
  (slack/request-get "users.info" {:token token :user user}))

(defn list
  "This method returns a list of all users in the team. This includes deleted/deactivated users.

  Required arguments are:
  * token -- Authentication token

  Options keywords are:
  * :cursor -- Paginate through collections of data by setting the cursor parameter to a next_cursor attribute returned by a previous request's response_metadata.
  * :limit -- The maximum number of items to return
  * :presence -- Whether to include presence data in the output."
  ([token]
   (list token {}))
  ([token opts]
   (slack/request-get "users.list" (conj opts {:token token}))))

(defn set-active
  "This method lets the slack messaging server know that the authenticated user is currently active.

  Required arguments are:
  * token -- Authentication token."
  [token]
  (slack/request-get "users.setActive" {:token token}))

(defn set-photo
  "This method allows the user to set their profile image.

  Required arguments are:
  * token -- Authentication token
  * image -- File contents via multipart/form-data

  Options keywords are:
  * :crop_w -- Width/height of crop box (always square)
  * :crop_x -- X coordinate of top-left corner of crop box
  * :crop_y -- Y coordinate of top-left corner oc crop bpx."
  ([token image]
   (set-photo token image {}))
  ([token image opts]
   (slack/request-get "users.setPhoto" (conj opts {:token token :image image}))))

(defn set-presence
  "This method lets you set the calling user's manual presence.

  Required arguments are:
  * token -- Authentication token
  * presence -- Either auto or away."
  [token presence]
  (slack/request-get "users.setPresence" {:token token :presence presence}))
