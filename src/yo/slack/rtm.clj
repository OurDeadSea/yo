(ns yo.slack.rtm)

(defn connect
  "This method begins a Real Time Messaging API session and reserves your application a specific URL with which to connect via websocket.

  Required arguments are:
  * token -- Authentication token

  Options arguments are:
  * :batch_presence_aware -- Group presence change notices as presence_change_batch events when possible
  * :presence_sub -- Only deliver presence events when requested by subscription."
  ([token]
   (connect token {}))
  ([token opts]
   :TODO))

(defn start
  "This method begins a Real Time Messaging API session and reserves your application a specific URL with which to connect via websocket.

  Required arguments are:
  * token -- Authentication token

  Options arguments are:
  * :batch_presence_aware -- Group presence change notices as presence_change_batch events when possible
  * :mpim_aware -- Returns MPIMs to the client in the API response
  * :no_latest -- Exclude latest timestamps for channels, groups, mpims, and ims
  * :no_unreads -- Skip unread counts for each channel (improves performance)
  * :presence_sub -- Only deliver presence events when requested by subscription
  * :simple_latest -- Return timestamp only for latest message object of each channel (improves performance)."
  ([token]
   (start token {}))
  ([token opts]
   :TODO))



