(ns yo.slack.oauth
  (:require [yo.slack.core :as slack]))

(defn access
  "This method allows you to exchange a temporary OAuth code for an API access token. 

  Required arguments are:
  * client-id -- Issued when you created your application
  * client-secret -- Issued when you created your application
  * code -- The code param returned via the OAuth callback
  
  Options keywords are:
  * :redirect_url -- This must match the originally submitted URI (if one was sent)"
  ([client-id client-secret code]
   (access client-id client-secret code {}))
  ([client-id client-secret code opts]
   (slack/request-get "oauth.access"
                      (conj opts {:client_id client-id :client_secret client-secret :code code}))))
