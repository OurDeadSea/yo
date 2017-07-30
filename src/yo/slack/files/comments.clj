(ns yo.slack.files.comments
  (:require [yo.slack.core :as slack]))

(defn add
  "Add a comment to an existing file.

  Required arguments are:
  * token -- Authentication token
  * comment -- Text of the comment to add
  * file -- File to add a comment to"
  [token comment file]
  (slack/request-get "files.comments.add" {:token token :comment comment :file file}))

(defn delete
  "Delete an existing comment on a file.

  Required arguments are:
  * token -- Authentication token
  * file -- File to delete a comment from
  * id -- The comment to delete"
  [token file id]
  (slack/request-get "files.comments.delete" {:token token :file file :id id}))


(defn edit
  "Edit an existing comment on a file.

  Required arguments are:
  * token -- Authentication token
  * comment -- Text of the comment to edit
  * file -- File containing the comment to edit
  * id -- The comment to edit"
  [token comment file id]
  (slack/request-get "files.comments.edit" {:token token :comment comment :file file :id id}))
