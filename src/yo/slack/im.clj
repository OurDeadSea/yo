(ns yo.slack.im
  (:require [yo.slack.core :as slack])
  (:refer-clojure :exclude [list]))

(defn close
  "This method closes a direct message channel.

  Required arguments are:
  * token -- Authentication token
  * channel -- Direct message channel to close"
  [token channel]
  (slack/request-get "im.close" {:token token :channel channel}))

(defn history
  "This method returns a portion of messages/events from the specified direct message channel.

  Required arguments are:
  * token -- Authentication token
  * channel -- Direct message channel to fetch history for

  Options keywords are:
  * :count -- Number of messages to return, between 1 and 1000
  * :inclusive -- Include messages with latest or oldest timestamp in results
  * :latest -- End of time range of messages to include in results
  * :oldest -- Start of time range of messages to include in results
  * :unreads -- Include unread_count_display in the output?"
  ([token channel]
   (history token channel {}))
  ([token channel opts]
   (slack/request-get "im.history" (conj opts {:token token :channel channel}))))

(defn list
  "This method returns a list of all im channels that the user has.

  Required arguments are:
  * token -- Authentication token"
  [token]
  (slack/request-get "im.list" {:token token}))

(defn mark
  "This method moves the read cursor in a direct message channel.

  Required arguments are:
  * token -- Authentication token
  * channel -- Direct message channel to set reading cursor in
  * ts -- Timestamp of the most recently seen message"
  [token channel ts]
  (slack/request-get "im.mark" {:token token :channel channel :ts ts}))

(defn open
  "This method opens a direct message channel with another member of your Slack team.

  Required arguments are:
  * token -- Authentication token
  * user -- User to open a direct message channel with

  Options keywords are:
  * :return_im -- Boolean, indicates you want the full IM channel definition in the response"
  ([token user]
   (open token user {}))
  ([token user opts]
   (slack/request-get "im.open" (conj opts {:token token :user user}))))

(defn replies
  "This method returns an entire thread (a message plus all the messages in reply to it).

  Required arguments are:
  * token -- Authentication token
  * channel -- Direct message channel to fetch thread from
  * thread-ts -- Unique identifier of a thread's parent message"
  [token channel thread-ts]
  (slack/request-get "im.replies" {:token token :channel channel :thread_ts thread-ts}))
