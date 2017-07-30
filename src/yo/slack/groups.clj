(ns yo.slack.groups
  (:require [yo.slack.core :as slack])
  (:refer-clojure :exclude [list]))

(defn archive
  "This method archives a private channel.

  Required arguments are:
  * token -- Authentication token
  * channel -- Private channel to archive"
  [token channel]
  (slack/request-get "groups.archive" {:token token :channel channel}))

(defn close
  "This method closes a private channel.

  Required arguments:
  * token -- Authentication token
  * channel -- Private channel to close"
  [token channel]
  (slack/request-get "groups.close" {:token token :channel channel}))

(defn create
  "This method creates a private channel.

  Required arguments are:
  * token -- Authentication token
  * name -- Name of private channel to create

  Options keywords are:
  * :validate -- Whether to return errors on invalid channel name instead of modifying it to meet the specified criteria"
  ([token name]
   (create token name {}))
  ([token name opts]
   (slack/request-get "groups.create" (conj opts {:token token :name name}))))

(defn create-child
  "This method takes an existing private channel and performs the following steps:

  - Renames the existing private channel (from 'example' to 'example-archived').
  - Archives the existing private channel.
  - Creates a new private channel with the name of the existing private channel.
  - Adds all members of the existing private channel to the new private channel.
  
  Required arguments are:
  * token -- Authentication token
  * channel -- Private channel to clone and archive"
  [token channel]
  (slack/request-get "groups.createChild" {:token token :channel channel}))

(defn history
  "This method returns a portion of messages/events from the specified private channel.

  Required arguments are:
  * token -- Authentication token
  * channel -- Private channel to fetch history for
  
  Options keywords are:
  * :count -- Number of messages to return, between 1 and 1000
  * :inclusive -- Include messages with latest or oldest timestamp in results
  * :latest -- End of time range of messages to include in results
  * :oldest -- Start of time range of messages to include in results
  * :unreads -- Include unread_count_display in the output?"
  ([token channel]
   (history token channel {}))
  ([token channel opts]
   (slack/request-get "groups.history" (conj opts {:token token :channel channel}))) )

(defn info
  "This method returns information about a private channel.

  Required arguments are:
  * token -- Authentication token
  * channel -- Private channel to get info on"
  [token channel]
  :TODO)

(defn invite
  "This method is used to invite a user to a private channel.
  
  Required arguments are:
  * token -- Authentication token
  * channel -- Private channel to invite user to
  * user -- User to invite"
  [token channel user]
  (slack/request-get "groups.invite" {:token token :channel channel :user user}))

(defn kick
  "This method allows a user to remove another member from a private channel.

  Required arguments are:
  * token -- Authentication token
  * channel -- Private channel to remove user from
  * user -- User to remove from private channel"
  [token channel user]
  (slack/request-get "groups.kick" {:token token :channel channel :user user}))

(defn leave
  "This method is used to leave a private channel.

  Required arguments are:
  * token -- Authentication token
  * channel -- Private channel to leave"
  [token channel]
  (slack/request-get "groups.leave" {:token token :channel channel}))

(defn list
  "This method returns a list of private channels in the team that the caller is in and archived groups that the caller was in.
  
  Required arguments are:
  * token -- Authentication token
  
  Options keywords are:
  * :exclude_archived -- Don't retuen archived private channels
  * :exclude_members -- Exclude the members from each group"
  ([token]
   (list token {}))
  ([token opts]
   (slack/request-get "groups.list" (conj opts {:token token}))))

(defn mark
  "This method moves the read cursor in a private channel.

  Required arguments are:
  * token -- Authentication token
  * channel -- Private channel to set reading cursor in
  * ts -- Timestamp of the most recently seen message"
  [token channel ts]
  (slack/request-get "groups.mark" {:token token :channel channel :ts ts}))

(defn open
  "This method opens a private channel.
  
  Required arguments are:
  * token -- Authentication token
  * channel -- Private channel to open"
  [token channel]
  (slack/request-get "groups.open" {:token token :channel channel}))

(defn rename
  "This method renames a private channel.

  Required arguments are:
  * token -- Authentication token
  * channel -- Private channel to rename
  * name -- New name for private channel
  
  Options keywords are:
  * :validate -- Whether to return errors on invalid channel name instead of modifying it to meet the specified criteria"
  ([token channel name]
   (rename token channel name {}))
  ([token channel name opts]
   (slack/request-get "groups.rename" (conj opts {:token token :channel channel :name name}))))

(defn replies
  "This method returns an entire thread (a message plus all the messages in reply to it).

  Required arguments are:
  * token -- Authentication token
  * channel -- Private channel to fetch thread from
  * thread-ts -- Unique identifier of a thread's parent message"
  [token channel thread-ts]
  (slack/request-get "groups.replies" {:token token :channel channel :thread_ts thread-ts}))

(defn set-purpose
  "This method is used to change the purpose of a private channel.

  Required arguments are:
  * token -- Authentication token
  * channel -- Private channel to set the purpose of
  * purpose -- The new purpose"
  [token channel purpose]
  (slack/request-get "groups.setPurpose" {:token token :channel channel :purpose purpose}))

(defn set-topic
  "This method is used to change the topic of a private channel. 

  Required arguments are:
  * token -- Authentication token
  * channel -- Private channel to set the topic of
  * topic -- The new topic"
  [token channel topic]
  (slack/request-get "groups.setTopic" {:token token :channel channel :topic topic}))

(defn unarchive
  "This method unarchives a private channel.

  Required arguments are:
  * token -- Authentication token
  * channel -- Private channel to unarchive"
  [token channel]
  (slack/request-get "groups.unarchive" {:token token :channel channel}))
