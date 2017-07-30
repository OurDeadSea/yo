(ns yo.slack.users)

(defn deletePhoto
  "This method allows the user to delete their profile image. It will clear whatever image is currently set.

  Required arguments are:
  * token -- Authentication token."
  [token]
  :TODO)

(defn getPresence
  "This method lets you find out information about a user's presence.

  Required arguments are:
  * token -- Authentication token
  * user -- User to get presence info on."
  [token user]
  :TODO)

(defn identity
  "After your Slack app is awarded an identity token through Sign in with Slack, use this method to retrieve a user's identity.

  Required arguments are:
  * token -- Authentication token."
  [token]
  :TODO)

(defn info
  "This method returns information about a team member.

  Required arguments are:
  * token -- Authentication token
  * user -- User to get info on"
  [token user]
  :TODO)

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
   :TODO))

(defn setActive
  "This method lets the slack messaging server know that the authenticated user is currently active.

  Required arguments are:
  * token -- Authentication token."
  [token]
  :TODO)

(defn setPhoto
  "This method allows the user to set their profile image.

  Required arguments are:
  * token -- Authentication token
  * image -- File contents via multipart/form-data

  Options keywords are:
  * :crop_w -- Width/height of crop box (always square)
  * :crop_x -- X coordinate of top-left corner of crop box
  * :crop_y -- Y coordinate of top-left corner oc crop bpx."
  ([token image]
   (setPhoto token image {}))
  ([token image opts]
   :TODO))

(defn setPresence
  "This method lets you set the calling user's manual presence.

  Required arguments are:
  * token -- Authentication token
  * presence -- Either auto or away."
  [token presence]
  :TODO)





