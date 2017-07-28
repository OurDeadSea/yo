(ns yo.slack.files.comments)

(defn add
  "Add a comment to an existing file.

  Required arguments are:
  * token -- Authentication token
  * comment -- Text of the comment to add
  * file -- File to add a comment to"
  [token comment file]
  :TODO)

(defn delete
  "Delete an existing comment on a file.

  Required arguments are:
  * token -- Authentication token
  * file -- File to delete a comment from
  * id -- The comment to delete"
  [token file id]
  :TODO)


(defn edit
  "Edit an existing comment on a file.

  Required arguments are:
  * token -- Authentication token
  * comment -- Text of the comment to edit
  * file -- File containing the comment to edit
  * id -- The comment to edit"
  [token comment file id]
  :TODO)
