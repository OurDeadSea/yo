(ns yo.slack.search
  (:require [yo.slack.core :as slack]))

(defn all
  "This method allows users and applications to search both messages and files in a single call.

  Required arguments are:
  * token -- Authentication token
  * query -- Search query

  Options keywords are:
  * :count -- Number of items to return per page
  * :highlight -- Pass a value of true to enable query highlight markers
  * :page -- Page number of results to return
  * :sort -- Return matches sorted by either score or timestamp
  * :sort_dir -- Change sort direction to ascending (asc) or descending (desc)."
  ([token query]
   (all token query {}))
  ([token query opts]
   (slack/request-get "search.all" (conj opts {:token token :query query}))))

(defn files
  "This method returns files matching a search query.

  Required arguments are:
  * token -- Authentication token
  * query -- Search query

  Options keywords are:
  * :count -- Number of items to return per page
  * :highlight -- Pass a value of true to enable query highlight markers
  * :page -- Page number of results to return
  * :sort -- Return matches sorted by either score or timestamp
  * :sort_dir -- Change sort direction to ascending (asc) or descending (desc)."
  ([token query]
   (files token query {}))
  ([token query opts]
   (slack/request-get "search.files" (conj opts {:token token :query query}))))

(defn messages
  "This method returns messages matching search query.

  Required arguments are:
   * token -- Authentication token
   * query -- Search query

  Options keywords are:
  * :count -- Number of items to return per page
  * :highlight -- Pass a value of true to enable query highlight markers
  * :page -- Page number of results to return
  * :sort -- Return matches sorted by either score or timestamp
  * :sort_dir -- Change sort direction to ascending (asc) or descending (desc)."
  ([token query]
   (messages token query {}))
  ([token query opts]
   (slack/request-get "search.messages" (conj opts {:token token :query query}))))
