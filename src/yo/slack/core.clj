(ns yo.slack.core
  (:require [clj-http.client :as http]
            [clojure.data.json :as json]
            [clojure.tools.logging :as log])
  (:import [java.net URLEncoder]))

(def api-url
  "Slack's API URL."
  "https://slack.com/api")

(def error-description
  {"bot_not_found"        "Value passed for bot was invalid."
   "channel_not_found"    "Value passed for channel was invalid."
   "restricted_action"    "A team preference prevents the authenticated user from archiving."
   "already_archived"     "Channel has already been archived."
   "cant_archive_general" "You cannot archive the general channel."
   "not_authed"           "No authentication token provided."
   "invalid_auth"         "Invalid authentication token."
   "account_inactive"     "Authentication token is for a deleted user or team."
   "user_is_bot"          "This method cannot be called by a bot user."
   "user_is_restricted"   "This method cannot be called by a restricted user or single channel guest."
   "invalid_arg_name"     "The method was passed an argument whose name falls outside the bounds of common decency. This includes very long names and names with non-alphanumeric characters other than _. If you get this error, it is typically an indication that you have made a very malformed API call."
   "invalid_array_arg"    "The method was passed a PHP-style array argument (e.g. with a name like foo[7]). These are never valid with the Slack API."
   "invalid_charset"      "The method was called via a POST request, but the charset specified in the Content-Type header was invalid. Valid charset names are: utf-8 iso-8859-1."
   "invalid_form_data"    "The method was called via a POST request with Content-Type application/x-www-form-urlencoded or multipart/form-data, but the form data was either missing or syntactically invalid."
   "invalid_post_type"    "The method was called via a POST request, but the specified Content-Type was invalid. Valid types are: application/x-www-form-urlencoded multipart/form-data text/plain."
   "missing_post_type"    "The method was called via a POST request and included a data payload, but the request did not include a Content-Type header."
   "team_added_to_org"    "The team associated with your request is currently undergoing migration to an Enterprise Organization. Web API and other platform operations will be intermittently unavailable until the transition is complete."
   "request_timeout"      "The method was called via a POST request, but the POST data was either missing or truncated."
   "name_taken"           "A channel cannot be created with the given name."
   "no_channel"           "Value passed for name was empty."})

(def warning-description
  {"missing_charset"     "The method was called via a POST request, and recommended practice for the specified Content-Type is to include a charset parameter. However, no charset was present. Specifically, non-form-data content types (e.g. text/plain) are the ones for which charset is recommended."
   "superfluous_charset" "The method was called via a POST request, and the specified Content-Type is not defined to understand the charset parameter. However, charset was in fact present. Specifically, form-data content types (e.g. multipart/form-data) are the ones for which charset is superfluous."})

(defn perform-http-get
  "Performs an HTTP GET request.

  Returns json on success and nil on error."
  [url params]
  (let [response (http/get url {:query-params params})
        body     (:body response)]
    (if body
      (json/read-str body :key-fn keyword)
      (log/error "Error from Slack API" ":error =" (:error response)))))

(defn perform-http-post
  "Performs an HTTP POST request.

  Returns json response."
  [url params]
  (let [response (http/post url {:form-params params})
        body     (:body response)]
    (if body
      (json/read-str (:body response) :key-fn keyword)
      (log/error "Error from Slack API" ":error =" (:error response)))))

(defn process-response
  [response method params]
  (cond (:error response)   (log/error "Failed Slack API call" method
                                       ":error =" (:error response) ":params =" params
                                       ":description =" (error-description (:error response)))
        (:warning response) (log/warn "Problematic Slack API call" method
                                      ":warning =" (:warning response) ":params =" params
                                      ":description =" (warning-description (:warning response)))
        (:ok response)      (log/info "Successfull Slack API call" method
                                      ":params =" params)
        :else               (log/fatal "Malformed Slack API response" method
                                       ":params =" params))
  response)

(defn request-get
  [method params]
  (log/info "Slack API GET" method ":params =" params)
  (let [url      (str api-url "/" method)
        response (perform-http-get url params)]
    (process-response response method params)))

(defn request-post
  [method params]
  (log/info "Slack API POST" method ":params =" params)
  (let [url      (str api-url "/" method)
        response (perform-http-post url params)]
    (process-response response method params)))
