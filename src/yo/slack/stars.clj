(ns yo.slack.stars)

(defn add
  "This method adds a star to an item (message, file, file comment, channel, private group, or DM) on behalf of the authenticated user.

  Required arguments are:
  * token -- Authentication token

  Options keywords are:
  * :channel -- Channel to add star to, or channel where the message to add star to was posted (used with timestamp)
  * :file -- File to add star to
  * :file_comment -- File comment to add star to
  * :timestamp -- Timestamp of the message to add star to."
  ([token]
   (add token {}))
  ([token opts]
   :TODO))

(defn list
  "This method lists the items tarred by the authed user.

  Required arguments are:
  * token -- Authentication token

  Options keywords are:
  * :count -- Number of items to return per page
  * :page -- Page number of results to return."
  ([token]
   (list token {}))
  ([token opts]
   :TODO))

(defn remove
  "This method removes a star from an item (message, file, file comment, channel, private group, or DM) on behalf of the authenticated user.

  Required arguments are:
  * token -- Authentication token

  Options keywords are:
  * :channel -- Channel to remove star from, or channel where the message to remove star from was posted (used with timestamp)
  * :file -- File to remove star from
  * :file_comment -- File comment to remove star from
  * :timestamp -- Timestamp od the message to remove star from."
  ([token]
   (remove token {}))
  ([token opts]
   :TODO))


