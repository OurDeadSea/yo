(ns yo.slack.bots)

(defn info
  "This method returns information about a bot user.

  Required arguments are:
  * token -- Authentication token
  
  Options keywords are:
  * :bot -- Bot user to get info on"
  ([token]
   (info token {}))
  ([token opts]
   :TODO))
