(ns yo.slack.files
  (:require [yo.slack.core :as slack])
  (:refer-clojure :exclude [list]))

(defn delete
  "This method deletes a file from your team.

  Required arguments are:
  * token -- Authentication token
  * file -- ID of file to delete"
  [token file]
  (slack/request-get "files.delete" {:token token :file file}))

(defn info
  "This method returns information about a file in your team.

  Required arguments are:
  * token -- Authentication token
  * file -- Specify a file by providing its ID
  
  Options keywords are:
  * :count -- Number of items to return per page
  * :page -- Page number of results to return"
  ([token file]
   (info token file {}))
  ([token file opts]
   (slack/request-get "files.info" (conj opts {:token token :file file}))))

(defn list
  "This method returns a list of files within the team. It can be filtered and sliced in various ways.

  Required arguments are:
  * token -- Authentication token
  
  Options keywords are:
  * :channel -- Filter files appearing in a specific channel, indicated by its ID
  * :count -- Number of items to return per page
  * :page -- Page number of results to return
  * :ts_from -- Filter files created after this timestamp (inclusive)
  * :ts_to -- Filter files created before this timestamp (inclusive)
  * :types -- Filter files by type (all, spaces, snippets, images, gdocs, zips, pdfs)
  * :user -- Filter files created by a single user"
  ([token]
   (list token {}))
  ([token opts]
   (slack/request-get "files.list" (conj opts {:token token}))))

(defn revoke-public-url
  "This method disables public/external sharing for a file.

  Required arguments are:
  * token -- Authentication token
  * file -- File to revoke"
  [token file]
  (slack/request-get "files.revokePublicURL" {:token token :file file}))


(defn shared-public-url
  "This method enables public/external sharing for a file.

  Required arguments are:
  * token -- Authentication token
  * file -- File to share"
  [token file]
  (slack/request-get "files.sharedPublicURL" {:token token :file file}))

(defn upload
  "This method allows you to create or upload an existing file.

  Required arguments are:
  * token -- Authentication token

  Options keywords are:
  * :channels -- Comma-separated list of channel names or IDs where the file will be shared
  * :content -- File contents via a POST variable
  * :file -- File contents via multipart/form-data
  * :filename -- Filename of file
  * :filetype -- A file type identifier
  * :initial_comment -- Initial comment to add to file
  * :title -- Title of file"
  ([token]
   (upload token))
  ([token opts]
   (slack/request-get "files.upload" (conj opts {:token token}))))
