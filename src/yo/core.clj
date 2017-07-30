(ns yo.core
  (:require [yo.slack.core :as slack]
            [yo.slack.api :as slack.api]
            [yo.slack.auth :as slack.auth]
            [yo.slack.bots :as slack.bots]
            [yo.slack.channels :as slack.channels]
            [yo.slack.chat :as slack.chat]
            [yo.slack.dnd :as slack.dnd]
            [yo.slack.emoji :as slack.emoji]
            [yo.slack.files.comments :as slack.files.comments]
            [yo.slack.files :as slack.files]
            [yo.slack.groups :as slack.groups]
            [yo.slack.im :as slack.im]
            [yo.slack.mpim :as slack.mpim]
            [yo.slack.oauth :as slack.oauth]
            [yo.slack.pins :as slack.pins]
            [yo.slack.reactions :as slack.reactions]
            [yo.slack.reminders :as slack.reminders]
            [yo.slack.rtm :as slack.rtm]
            [yo.slack.search :as slack.search]
            [yo.slack.stars :as slack.stars]
            [yo.slack.team :as slack.team]
            [yo.slack.team.profile :as slack.team.profile]
            [yo.slack.usergroups :as slack.usergroups]
            [yo.slack.usergroups.users :as slack.usergroups.users]
            [yo.slack.users :as slack.users]
            [yo.slack.users.profile :as slack.users.profile])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Called with these arguments: " args))
