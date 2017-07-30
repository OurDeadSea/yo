(ns yo.slack.team.profile)

(defn get
  "This method is used to get the profile field definitions for this team

  Required arguments are:
  * token -- Authentication token

  Options keywords are:
  * :visibility -- Filter by visibility."
  ([token]
   (get token {}))
  ([token opts]
   :TODO))

