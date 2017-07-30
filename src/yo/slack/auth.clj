(ns yo.slack.auth
  (:require [yo.slack.core :as slack])
  (:refer-clojure :exclude [test]))

(defn revoke
  "This method revokes an access token. Use it when you no longer need a token.
  
  Required arguments are:
  * token -- Authentication token
  
  Options keywords are:
  * :test -- Setting this parameter to 1 triggers a testing mode where the specified token will not actually be revoked"
  ([token]
   (revoke token {}))
  ([token opts]
   (slack/request-get "auth.revoke" (conj opts {:token token}))))


(defn test
  "This method checks authentication and tells you who you are.

  Required arguments are:
  * token -- Authentication token"
  [token]
  (slack/request-get "auth.test" {:token token}))
