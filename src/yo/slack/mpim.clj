(ns yo.slack.mpim
  (:require [yo.slack.core :as slack])
  (:refer-clojure :exclude [list]))

(defn close
  "This method closes a multiparty direct message channel.

  Required arguments are:
  * token -- Authentication token
  * channel -- MPIM to close"
  [token channel]
  (slack/request-get "mpim.close" {:token token :channel channel}))

(defn history
  "This method returns a portion of messages/events from the specified multiparty direct message channel. To read the entire history for a multiparty direct message, call the method with no latest or oldest arguments, and then continue paging using the instructions below.

  Required arguments are:
  * token -- Authentication token.
  * channel -- Multiparty direct message to fetch history for

  Options keywords are:
  * :count -- Number of messages to return, between 1 and 1000
  * :inclusive -- Include messages with latest or oldest timestamp in results
  * :latest -- End of time range of messages to include in results
  * :oldest -- Start of time range of messages to include in results
  * :unreads -- Include unread_count_display in the output?"
  ([token channel]
   (history token channel {}))
  ([token channel opts]
   (slack/request-get "mpim.history" (conj opts {:token token :channel channel}))))

(defn list
  "This method returns a list of all multiparty direct message channels that the user has.

  Required arguments are:
  * token -- Authentication token."
  [token]
  (slack/request-get "mpim.list" {:token token}))

(defn mark
  "This method moves the read cursor in a multiparty direct message channel.

  Required arguments are:
  * token -- Authentication token
  * channel -- multiparty direct message channel to set reading cursor in
  * ts -- Timestamp of the most recently seen message"
  [token channel ts]
  (slack/request-get "mpim.mark" {:token token :channel channel :ts ts}))

(defn open
  "This method opens a multiparty direct message.

  Required arguments are:
  * token -- Authentication token
  * users -- Comma separated lists of users."
  [token users]
  (slack/request-get "mpim.open" {:token token :users users}))

(defn replies
  "This method returns an entire thread (a message plus all the messages in reply to it).

  Required arguments are:
  * token -- Authentication token
  * channel -- Multiparity direct message channel to fetch thread from.
  * thread_ts -- Unique identifier of a thread's parent message."
  [token channel thread-ts]
  (slack/request-get "mpim.replies" {:token token :channel channel :thread_ts thread-ts}))
