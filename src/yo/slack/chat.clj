(ns yo.slack.chat
  (:require [yo.slack.core :as slack])
  (:refer-clojure :exclude [update]))

(defn delete
  "This method deletes a message from a channel.

  Required arguments are:
  * token -- Authentication token
  * channel -- Channel containing the message to be deleted
  * ts -- Timestamp of the message to be deleted

  Options keywords are:
  * :as_user -- Pass true to delete the message as the authed user. Bot users in this context are considered authed users."
  ([token channel ts]
   (delete token channel ts {}))
  ([token channel ts opts]
   (slack/request-get "chat.delete" (conj opts {:token token :channel channel :ts ts}))))

(defn me-message
  "This method sends a me message to a channel from the calling user.

  Required arguments are:
  * token -- Authentication token
  * channel -- Channel to send message to
  * text -- Text of the message to send"
  [token channel text]
  (slack/request-get "chat.meMessage" {:token token :channel channel :text text}))

(defn post-message
  "This method posts a message to a public channel, private channel, or direct message/IM channel.

  Required arguments are:
  * token -- Authentication token
  * channel -- Channel, private group, or IM channel to send message to
  * text -- Text of the message to send

  Options keywords are:
  * :as_user -- Pass true to post the message as the authed user, instead of as a bot
  * :attachments -- Structured message attachments
  * :icon_emoji -- Emoji to use as the icon for this message
  * :icon_url -- URL to an image to use as the icon for this message
  * :link_names -- Find and link channel names and usernames
  * :parse -- Change how messages are treated
  * :reply_broadcast -- Used in conjunction with thread_ts and indicates whether reply should be made visible to everyone in the channel or conversation
  * :thread_ts -- Provide another message's ts value to make this message a reply
  * :unfurl_links -- Pass true to enable unfurling of primarily text-based content
  * :unfurl_media -- Pass false to disable unfurling of media content
  * :username -- Set your bot's user name"
  ([token channel text]
   (post-message token channel text {}))
  ([token channel text opts]
   (slack/request-get "chat.postMessage" (conj opts {:token token :channel channel :text text}))))

(defn unfurl
  "This method attaches Slack app unfurl behavior to a specified and relevant message.

  Required arguments are:
  * token -- Authentication token
  * channel -- Channel ID of the message
  * ts -- Timestamp of the message to add unfurl behavior to
  * unfurls -- JSON mapping a set of URLs from the message to their unfurl attachments

  Options keywords are:
  * :user_auth_required -- Set to true or 1 to indicate the user must install your Slack app to trigger unfurls for this domain"
  ([token channel ts unfurls]
   (unfurl token channel ts unfurls {}))
  ([token channel ts unfurls opts]
   (slack/request-get "chat.unfurl" (conj opts {:token token :channel channel :ts ts :unfurls unfurls}))))

(defn update
  "This method updates a message in a channel.

  Required arguments are:
  * token -- Authentication token
  * channel -- Channel containing the message to be updated
  * text -- New text for the message
  * ts -- Timestamp of the message to be updated

  Options keywords are:
  * :as_user -- Pass true to update the message as the authed user
  * :attachments -- Structured message attachments
  * :link_names -- Find and link channel names and usernames
  * :parse -- Change how messages are treated"
  ([token channel text ts]
   (update token channel text ts {}))
  ([token channel text ts opts]
   (slack/request-get "chat.update" (conj opts {:token token :channel channel :text text :ts ts}))))
