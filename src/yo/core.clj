(ns yo.core
  (:require [yo.slack.core :as slack]
            [yo.slack.api :as api]
            [yo.slack.auth :as auth]
            [yo.slack.bots :as bots]
            [yo.slack.channels :as channels]
            [yo.slack.chat :as chat]
            [yo.slack.dnd :as dnd]
            [yo.slack.emoji :as emoji]
            [yo.slack.files.comments :as files.comments]
            [yo.slack.files :as files]
            [yo.slack.groups :as groups]
            [yo.slack.im :as im]
            [yo.slack.mpim :as mpim]
            [yo.slack.oauth :as oauth]
            [yo.slack.pins :as pins]
            [yo.slack.reactions :as reactions]
            [yo.slack.reminders :as reminders]
            [yo.slack.rtm :as rtm]
            [yo.slack.search :as search]
            [yo.slack.stars :as stars]
            [yo.slack.team :as team]
            [yo.slack.team.profile :as team.profile]
            [yo.slack.usergroups :as usergroups]
            [yo.slack.usergroups.users :as usergroups.users]
            [yo.slack.users :as users]
            [yo.slack.users.profile :as users.profile]
            [environ.core :refer [env]])
  (:gen-class))

(def oauth-token     (env :oauth-token))
(def oauth-bot-token (env :bot-oauth-token))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  nil)
