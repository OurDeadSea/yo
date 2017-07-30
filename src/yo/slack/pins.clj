(ns yo.slack.pins
  (:require [yo.slack.core :as slack])
  (:refer-clojure :exclude [get list remove]))

(defn add
  "This method adds a reaction (emoji) to an item (file, file comment, channel message, group message, or direct message).

  Required arguments are:
  * token -- Authentication token
  * name -- Reaction (emoji) name
  
  Options keywords are:
  * :channel -- Channel where the message to add reaction to was posted
  * :file -- File to add reaction to
  * :file_comment -- File comment to add reaction to
  * :timestamp -- Timestamp of the message to add reaction to"
  ([token name]
   (add token name {}))
  ([token name opts]
   (slack/request-get "pins.add" (conj opts {:token token :name name}))))

(defn get
  "This method returns a list of all reactions for a single item (file, file comment, channel message, group message, or direct message).
  
  Required arguments are:
  * token -- Authentication token
  
  Options keywords are:
  * :channel -- Channel where the message to get reactions for was posted
  * :file -- File to get reactions for
  * :file_comment -- File comment to get reactions for
  * :full -- If true always return the complete reaction list
  * :timestamp -- Timestamp of the message to get reactions for"
  ([token]
   (get token {}))
  ([token opts]
   (slack/request-get "pins.get" (conj opts {:token token}))))

(defn list
  "This method returns a list of all items (file, file comment, channel message, group message, or direct message) reacted to by a user.

  Required arguments are:
  * token -- Authentication token
  
  Options keywords are:
  * :count -- Number of items to return per page
  * :full -- If true always return the complete reaction list
  * :page -- Page number of results to return
  * :user -- Show reactions made by this user"
  ([token]
   (list token {}))
  ([token opts]
   (slack/request-get "pins.list" (conj opts {:token token}))))

(defn remove
  "This method removes a reaction (emoji) from an item (file, file comment, channel message, group message, or direct message).
  
  Required arguments are:
  * token -- Authentication token
  * name -- Reaction (emoji) name
  
  Options keywords are:
  * :channel -- Channel where the message to remove reaction from was posted
  * :file -- File to remove reaction from
  * :file_comment -- File comment to remove reaction from
  * :timestamp -- Timestamp of the message to remove reaction from"
  ([token name]
   (remove token name {}))
  ([token name opts]
   (slack/request-get "pins.remove" (conj opts {:token token :name name}))))
