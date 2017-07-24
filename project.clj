(defproject yo "0.0.1"
  :description "Chat bot experiment"
  :url "https://github.com/OurDeadSea/yo"
  :license {:name "GNU General Public License v3.0"
            :url  "https://www.gnu.org/licenses/gpl-3.0.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot yo.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
