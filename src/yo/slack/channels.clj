(ns yo.slack.channels
  (:require [yo.slack.core :as slack])
  (:refer-clojure :exclude [list]))

(defn archive
  "This method archives a channel.

  Required arguments are:
  * token -- Authentication token
  * channel -- Channel to archive"
  [token channel]
  (slack/request-get "channels.archive" {:token token :channel channel}))

(defn create
  "This method is used to create a channel.

  Required arguments are:
  * token -- Authentication token
  * name -- Name of channel to create

  Options keywords are:
  * :validate -- Whether to return errors on invalid channel name instead of modifying it to meet the specified criteria"
  ([token name]
   (create token name {}))
  ([token name opts]
   (slack/request-get "channels.create" (conj opts {:token token :name name}))))

(defn history
  "This method returns a portion of message events from the specified public channel.

  Required arguments are:
  * token -- Authentication token
  * channel -- Channel to fetch history for

  Options keywords are:
  * :count -- Number of messages to return, between 1 and 1000
  * :inclusive -- Include messages with latest or oldest timestamp in results
  * :latest -- End of time range of messages to include in results
  * :oldest -- Start of time range of messages to include in results
  * :unreads -- Include :unread_count_display in the output?"
  ([token channel]
   (history token channel {}))
  ([token channel opts]
   (slack/request-get "channels.history" (conj opts {:token token :channel channel}))))

(defn info
  "This method returns information about a team channel.

  Required arguments are:
  * token -- Authentication token
  * channel -- Channel to get info on"
  [token channel]
  (slack/request-get "channels.info" {:token token :channel channel}))

(defn invite
  "This method is used to invite a user to a channel.

  Required arguments are:
  * token -- Authentication token
  * channel -- Channel to invite user to
  * user -- User to invite to channel"
  [token channel user]
  (slack/request-get "channels.invite" {:token token :channel channel :user user}))

(defn join
  "This method is used to join a channel. If the channel does not exist, it is created.

  Required arguments are:
  * token -- Authentication token
  * name -- Name of channel to join

  Options keywords are:
  * :validate -- Whether to return errors on invalid channel name instead of modifying it to meet the specified criteria"
  ([token name]
   (join token name {}))
  ([token name opts]
   (slack/request-get "channels.join" (conj opts {:token token :name name}))))

(defn kick
  "This method allows a user to remove another member from a team channel.

  Required arguments are:
  * token -- Authentication token
  * channel -- Channel to remove user from
  * user -- User to remove from channel"
  [token channel user]
  (slack/request-get "channels.kick" {:token token :channel channel :user user}))

(defn leave
  "This method is used to leave a channel.

  Required arguments are:
  * token -- Authentication token
  * channel -- Channel to leave"
  [token channel]
  (slack/request-get "channels.leave" {:token token :channel channel}))

(defn list
  "This method returns a list of all channels in the team.

  Required arguments are:
  * token -- Authentication token

  Options keywords are:
  * :exclude_archived -- Exclude archived channels from the list
  * :exclude_members -- Exclude the members collection from each channel"
  ([token]
   (list token {}))
  ([token opts]
   (slack/request-get "channels.list" (conj opts {:token token}))))

(defn mark
  "This method moves the read cursor in a channel.

  Required arguments are:
  * token -- Authentication token
  * channel -- Channel to set reading cursor in
  * ts -- Timestamp of the most recently seen message"
  [token channel ts]
  (slack/request-get "channels.mark" {:token token :channel channel :ts ts}))


(defn rename
  "This method renames a team channel.

  Required arguments are:
  * token -- Authentication token
  * channel -- Channel to rename
  * name -- New name for channel

  Options keywords are:
  * :validate -- Whether to return errors on invalid channel name instead of modifying it to meet the specified criteria"
  ([token channel name]
   (rename token channel name {}))
  ([token channel name opts]
   (slack/request-get "channels.rename" (conj opts {:token token :channel channel :name name}))))

(defn replies
  "This method returns an entire thread (a message plus all the messages in reply to it).

  Required arguments are:
  * token -- Authentication token
  * channel -- Channel to fetch thread from
  * thread_ts -- Unique identifier of a thread's parent message"
  [token channel thread-ts]
  (slack/request-get "channels.replies" {:token token :channel channel :thread_ts thread-ts}))

(defn set-purpose
  "This method is used to change the purpose of a channel. The calling user must be a member of the channel.

  Required arguments:
  * token -- Authentication token
  * channel -- Channel to set the purpose of
  * purpose -- The new purpose"
  [token channel purpose]
  (slack/request-get "channels.setPurpose" {:token token :channel channel :purpose purpose}))

(defn set-topic
  "This method is used to change the topic of a channel. The calling user must be a member of the channel.

  Required arguments are:
  * token -- Authentication token
  * channel -- Channel to set the topic of
  * topic -- The new topic"
  [token channel topic]
  (slack/request-get "channels.setTopic" {:token token :channel channel :topic topic}))

(defn unarchive
  "This method unarchives a channel. The calling user is added to the channel.

  Required arguments are:
  * token -- Authentication token
  * channel -- Channel to unarchive"
  [token channel]
  (slack/request-get "channels.unarchive" {:token token :channel channel}))
