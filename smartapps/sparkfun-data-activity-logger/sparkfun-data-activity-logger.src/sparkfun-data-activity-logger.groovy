/**
 *  Test App
 *
 *  Copyright 2014 Clay Barbee
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
definition(
    name: "Sparkfun Data Activity Logger",
    namespace: "Sparkfun Data Activity Logger",
    author: "Clay Barbee",
    description: "Logs activity to a Sparkfun Data stream",
    category: "My Apps",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png")


preferences {
	section("When activity happens on") {
		// TODO: put inputs here

        input "switches", "capability.switch",
            title: "Switches?", multiple: true
	}
    section("Log data to Sparkfun Stream") {
    	input(name: "PublicKey", title: "Public Key", type: "text", capitalization: "none", required: "true")
        input(name: "PrivateKey", title: "Private Key", type: "text", capitalization: "none", required: "true")
    }
}

def installed() {
    log.debug "Installed with settings: ${settings}"

	initialize()
}

def updated() {
	log.debug "Updated with settings: ${settings}"

	unsubscribe()
	initialize()
}

def initialize() {
	// TODO: subscribe to attributes, devices, locations, etc.
    subscribe(switches, "switch", switchHandler)
}

// TODO: implement event handlers
def switchHandler(evt) {
    log.debug "Switch state changed! It is now ${evt.value} at ${evt.date} and Public Key is $PublicKey"
    def switchstate=1
    if (evt.value=="on") {
        log.debug "it's on! ${switchstate=1}"}
    else {
        log.debug "it's off! ${switchstate=0}"}
    // Format: http://data.sparkfun.com/input/[publicKey]?private_key=[privateKey]&state=[value]
    def params = [
    uri: "http://data.sparkfun.com/input/${PublicKey}.json?private_key=${PrivateKey}&state=${switchstate}"
    ]

    try {
        httpGet(params) { resp ->
            resp.headers.each {
               log.debug "${it.name} : ${it.value}"
            }
            log.debug "response contentType: ${resp.contentType}"
            log.debug "response data: ${resp.data}"
        }
    } catch (e) {
        log.error "something went wrong: $e"
    }
}