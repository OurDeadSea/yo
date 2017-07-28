(ns yo.slack.auth)

(defn revoke
  "This method revokes an access token. Use it when you no longer need a token.
  
  Required arguments are:
  * token -- Authentication token
  
  Options keywords are:
  * :test -- Setting this parameter to 1 triggers a testing mode where the specified token will not actually be revoked"
  ([token]
   (revoke token {}))
  ([token opts]
   :TODO))


(defn test
  "This method checks authentication and tells you who you are.

  Required arguments are:
  * token -- Authentication token"
  [token]
  :TODO)
