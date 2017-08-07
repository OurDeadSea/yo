(ns yo.slack.rtm
  (:require [yo.slack.core :as slack]
            [clojure.core.async :as async :refer [chan go >! <! >!! <!! go-loop close!]]
            [clojure.data.json :as json]
            [gniazdo.core :as ws]))

(defn connect-into-websocket [url incoming]
  (ws/connect url
    :on-connect (fn [session] :TODO)
    :on-binary (fn [payload offset length] :TODO)
    :on-error (fn [throwable] :TODO)
    :on-close (fn [status-code reason] :TODO)
    :on-receive (fn [event]
                  (go (>! incoming (json/read-str event :key-fn keyword))))))

(defn- transmit-onto-websocket [ws-client outgoing]
  (go-loop []
    (let [event (<! outgoing)]
      (when event
        (if (= event :close)
          (ws/close ws-client)
          (ws/send-msg ws-client (json/write-str event)))
        (recur)))))

(defn establish [conn incoming outgoing]
  (when (:ok conn)
    (let [ws-client (connect-into-websocket (:url conn) incoming)]
      (transmit-onto-websocket ws-client outgoing))))

(comment

  (def incoming (chan))
  (def outgoing (chan))

  (go-loop []
    (let [event (<! incoming)]
      (when event
        (clojure.pprint/pprint event)
        (recur))))

  (establish (connect "<<bot token goes here>>") incoming outgoing)

  (>!! outgoing {:type "ping"})
  (>!! outgoing :close)

  )

(defn connect
  "This method begins a Real Time Messaging API session and reserves your application a specific URL with which to connect via websocket.

  Required arguments are:
  * token -- Authentication token

  Options keywords are:
  * :batch_presence_aware -- Group presence change notices as presence_change_batch events when possible
  * :presence_sub -- Only deliver presence events when requested by subscription."
  ([token]
   (connect token {}))
  ([token opts]
   (slack/request-get "rtm.connect" (conj opts {:token token}))))

(defn start
  "This method begins a Real Time Messaging API session and reserves your application a specific URL with which to connect via websocket.

  Required arguments are:
  * token -- Authentication token

  Options keywords are:
  * :batch_presence_aware -- Group presence change notices as presence_change_batch events when possible
  * :mpim_aware -- Returns MPIMs to the client in the API response
  * :no_latest -- Exclude latest timestamps for channels, groups, mpims, and ims
  * :no_unreads -- Skip unread counts for each channel (improves performance)
  * :presence_sub -- Only deliver presence events when requested by subscription
  * :simple_latest -- Return timestamp only for latest message object of each channel (improves performance)."
  ([token]
   (start token {}))
  ([token opts]
   (slack/request-get "rtm.start" (conj opts {:token token}))))
