(ns yo.slack.errors)

(def invalid-arg-name
  "The method was passed an argument whose name falls outside the bounds of accepted or expected values. This includes very long names and names with non-alphanumeric characters other than `_`. If you get this error, it is typically an indication that you have made a very malformed API call."
  "invalid_arg_name")

(def invalid-array-arg
  "The method was passed a PHP-style array argument (e.g. with a name like `foo[7]`). These are never valid with the Slack API."
  "invalid_array_arg")

(def invalid-charset
  "The method was called via a `POST` request, but the charset specified in the `Content-Type` header was invalid. Valid charset names are: `utf-8` `iso-8859-1`."
  "invalid_charset")

(def invalid-form-data
  "The method was called via a `POST` request with `Content-Type` `application/x-www-form-urlencoded` or `multipart/form-data`, but the form data was either missing or syntactically invalid."
  "invalid_form_data")

(def invalid-post-type
  "The method was called via a `POST` request, but the specified `Content-Type` was invalid. Valid types are: `application/x-www-form-urlencoded` `multipart/form-data` `text/plain`."
  "invalid_post_type")

(def missing-post-type
  "The method was called via a `POST` request and included a data payload, but the request did not include a `Content-Type` header."
  "missing_post_type")

(def team-added-to-org
  "The team associated with your request is currently undergoing migration to an Enterprise Organization. Web API and other platform operations will be intermittently unavailable until the transition is complete."
  "team_added_to_org")

(def request-timeout
  "The method was called via a `POST` request, but the `POST` data was either missing or truncated."
  "request_timeout")

(def descriptions
  "What each Slack API error message means."
  {invalid-arg-name
   "The method was passed an argument whose name falls outside the bounds of accepted or expected values. This includes very long names and names with non-alphanumeric characters other than `_`. If you get this error, it is typically an indication that you have made a very malformed API call."

   invalid-array-arg
   "The method was passed a PHP-style array argument (e.g. with a name like `foo[7]`). These are never valid with the Slack API."

   invalid-charset
   "The method was called via a `POST` request, but the charset specified in the `Content-Type` header was invalid. Valid charset names are: `utf-8` `iso-8859-1`."

   invalid-form-data
   "The method was called via a `POST` request with `Content-Type` `application/x-www-form-urlencoded` or `multipart/form-data`, but the form data was either missing or syntactically invalid."

   invalid-post-type
   "The method was called via a `POST` request, but the specified `Content-Type` was invalid. Valid types are: `application/x-www-form-urlencoded` `multipart/form-data` `text/plain`."

   team-added-to-org
   "The team associated with your request is currently undergoing migration to an Enterprise Organization. Web API and other platform operations will be intermittently unavailable until the transition is complete."

   request-timeout
   "The method was called via a `POST` request, but the `POST` data was either missing or truncated."
   
   })
