/**
 *  SecurityAlarmPanel
 *
 *  Author: ObyCode
 *   based on work by Josh Foshee
 *  Modified by Yves Racine to include system statuses
 *  Date: 2014-06-10
 */



metadata {
    // Automatically generated. Make future change here.
    definition (name: "SecurityAlarmPanel", author: "brice@obycode.com") {
        capability "Alarm"
        capability "Switch"
        capability "Motion Sensor"
        capability "Contact Sensor"
        capability "Refresh"
        
        attribute "alarmStatus", "string"
        attribute "garageDoor", "string"
        attribute "frontDoor", "string"
        attribute "backDoor", "string"
        attribute "livingRoomMotion", "string"
        attribute "breakfastWindows", "string"
        attribute "bedroom2Window", "string"
        attribute "guestBathroomWindow", "string"
        attribute "bedroom3Window", "string"
        attribute "livingRoomWindows", "string"
        attribute "masterBedroomWindows", "string"
        attribute "officeWindows", "string"
        attribute "diningWindows", "string"
        attribute "switchAway", "string"
        attribute "switchStay", "string"
        attribute "panic", "string"
        attribute "systemStatus", "string"
        attribute "response", "string"


        command "armAway"
        command "armStay"
        command "disarm"
        command "clear"
        command "update"
        command "chimeToggle"
        command "panic"
        command "away"
    }

        // Simulator metadata
    simulator {
            // status messages
            status "ping": "catchall: 0104 0000 01 01 0040 00 6A67 00 00 0000 0A 00 0A70696E67"
            status "hello": "catchall: 0104 0000 01 01 0040 00 0A21 00 00 0000 0A 00 0A48656c6c6f20576f726c6421"
    }

        // UI tile definitions
    tiles {
        
                standardTile("alarmStatus", "device.alarmStatus", width: 2, height: 2, canChangeIcon: false, canChangeBackground: false) {
                        state "ready", label: 'Ready', action: "armStay", icon: "st.Home.home2", backgroundColor: "#ffffff"
                        state "disarmed", label: 'Ready', action: "armAway", icon: "st.Home.home2", backgroundColor: "#ffffff"
                        state "notready", label: 'Not Ready', icon: "st.Home.home2", backgroundColor: "#ffa81e"
                        state "away", label: 'Away', action: "disarm", icon: "st.Home.home3", backgroundColor: "#add8e6"
                        state "stay", label: 'Stay', action: "disarm", icon: "st.Home.home4", backgroundColor: "#f1d801"
                        state "arming", label: 'Arming', action: "disarm", icon: "st.Home.home2", backgroundColor: "#B8B8B8"
                        state "alarm", label: 'Alarm', action: "clear", icon: "st.Home.home2", backgroundColor: "#ff0000"
                }
                standardTile("away", "device.awaySwitch", width: 1, height: 1, canChangeIcon: false, canChangeBackground: false) {
                        state "on", label: "Away", action: "disarm", icon: "st.Home.home3", backgroundColor: "#add8e6"
                        state "off", label: "Away", action: "armAway",icon: "st.Home.home3", backgroundColor: "#ffffff"
                }
                standardTile("stay", "device.staySwitch", width: 1, height: 1, canChangeIcon: false, canChangeBackground: false) {
                        state "on", label: "Stay", action: "disarm", icon: "st.Home.home4", backgroundColor: "#f1d801"
                        state "off", label: "Stay", action: "armStay",icon: "st.Home.home4", backgroundColor: "#ffffff"
                }
                
                // For the moment, each sensor has its own states due to a smartthings UI framework issue on android.
                // To be fixed later: states should be 'open', 'closed', 'active', 'inactive'
                
                standardTile("garageDoor", "device.garageDoor", width: 1, height: 1,inactiveLabel: false,  canChangeIcon: true, canChangeBackground: true) {
                        state "GD open", label:'garage\nDoor', icon: "st.contact.contact.open", backgroundColor: "#ffa81e"
                        state "GD closed", label:'garage\nDoor', icon: "st.contact.contact.closed", backgroundColor: "#79b821"
                }
				standardTile("frontDoor", "device.frontDoor",width: 1, height: 1, canChangeIcon: false, canChangeBackground: true) {
                        state "FD open", label:'front\nDoor', icon: "st.contact.contact.open", backgroundColor: "#ffa81e"
                        state "FD closed", label:'front\nDoor', icon: "st.contact.contact.closed", backgroundColor: "#79b821"
                }
                standardTile("backDoor", "device.backDoor", width: 1, height: 1,inactiveLabel: false, canChangeIcon: true, canChangeBackground: true) {
                        state "BD open", label:'back\nDoor', icon: "st.contact.contact.open", backgroundColor: "#ffa81e"
                        state "BD closed", label:'back\nDoor', icon: "st.contact.contact.closed", backgroundColor: "#79b821"
                }
                standardTile("livingRoomMotion", "device.livingRoomMotion", width: 1, height: 1,inactiveLabel: false, canChangeIcon:true, canChangeBackground: true) {
                        state "LRM active", label:'livRoom\nMotion', icon: "st.motion.motion.active", backgroundColor: "#ffa81e"
                        state "LRM inactive", label:'livRoom\nMotion', icon: "st.motion.motion.inactive", backgroundColor: "#79b821"
                }
                standardTile("breakfastWindows", "device.breakfastWindows", width: 1, height: 1,inactiveLabel: false, canChangeIcon: true, canChangeBackground: true) {
                        state "BWin open", label:'breakfast\nWindows', icon: "st.contact.contact.open", backgroundColor: "#ffa81e"
                        state "BWin closed", label:'breakfast\nWindows', icon: "st.contact.contact.closed", backgroundColor: "#79b821"
                }
                standardTile("bedroom2Window", "device.bedroom2Window", width: 1, height: 1,inactiveLabel: false, canChangeIcon: true, canChangeBackground: true) {
                        state "B2Win open", label:'bedroom2\nWindow', icon: "st.contact.contact.open", backgroundColor: "#ffa81e"
                        state "B2Win closed", label:'bedroom2\nWindow', icon: "st.contact.contact.closed", backgroundColor: "#79b821"
                }                
                standardTile("guestBathroomWindow", "device.guestBathroomWindow", width: 1, height: 1,inactiveLabel: false, canChangeIcon: true, canChangeBackground: true) {
                        state "GBWin open", label:'guest Bath\nWindow', icon: "st.contact.contact.open", backgroundColor: "#ffa81e"
                        state "GBWin closed", label:'guest Bath\nWindow', icon: "st.contact.contact.closed", backgroundColor: "#79b821"
                }
                standardTile("bedroom3Window", "device.bedroom3Window", width: 1, height: 1,inactiveLabel: false, canChangeIcon: true, canChangeBackground: true) {
                        state "B3Win open", label:'bedroom3\nWindow', icon: "st.contact.contact.open", backgroundColor: "#ffa81e"
                        state "B3Win closed", label:'bedroom3\nWindow', icon: "st.contact.contact.closed", backgroundColor: "#79b821"
                }
                standardTile("livingRoomWindows", "device.livingRoomWindows", width: 1, height: 1,inactiveLabel: false, canChangeIcon: true, canChangeBackground: true) {
                        state "LRWin open", label:'living Room\nWindows', icon: "st.contact.contact.open", backgroundColor: "#ffa81e"
                        state "LRWin closed", label:'living Room\nWindows', icon: "st.contact.contact.closed", backgroundColor: "#79b821"
                }
                standardTile("masterBedroomWindows", "device.masterBedroomWindows", width: 1, height: 1,inactiveLabel: false, canChangeIcon: true, canChangeBackground: true) {
                        state "MBWin open", label:'master\nWindows', icon: "st.contact.contact.open", backgroundColor: "#ffa81e"
                        state "MBWin closed", label:'master\nWindows', icon: "st.contact.contact.closed", backgroundColor: "#79b821"
                }
                standardTile("officeWindows", "device.officeWindows", width: 1, height: 1,inactiveLabel: false, canChangeIcon: true, canChangeBackground: true) {
                        state "OWin open", label:'office\nWindows', icon: "st.contact.contact.open", backgroundColor: "#ffa81e"
                        state "OWin closed", label:'office\nWindows', icon: "st.contact.contact.closed", backgroundColor: "#79b821"
                }
                standardTile("diningWindows", "device.diningWindows", width: 1, height: 1,inactiveLabel: false, canChangeIcon: true, canChangeBackground: true) {
                        state "DWin open", label:'dining\nWindows', icon: "st.contact.contact.open", backgroundColor: "#ffa81e"
                        state "DWin closed", label:'dining\nWindows', icon: "st.contact.contact.closed", backgroundColor: "#79b821"
                }
                standardTile("chime", "device.chime", width:1, height: 1, canChangeIcon: false, canChangeBackground: false) {
                        state "chimeOff", label:'Chime', action:'chimeToggle', icon:"st.secondary.off", backgroundColor: "#ffffff"
                        state "chimeOn", label:'', action:'chimeToggle', icon:"st.secondary.beep", backgroundColor: "#ffffff"
                }
                standardTile("panic", "device.panic", width: 1, height: 1, canChangeIcon: false, canChangeBackground: true) {
                        state "panic", label:'Panic', action:"panic", icon:"st.alarm.alarm.alarm", backgroundColor:"#ff0000"
                }
		        valueTile("systemStatus", "device.systemStatus", inactiveLabel: false,
		 	               decoration: "flat", width: 3, height: 1) {
			               state "default", label: '${currentValue}'
		        }
                standardTile("refresh", "device.refresh", inactiveLabel: false, width: 1, height: 1, canChangeIcon: false, canChangeBackground: false) {
                        state "default", action:"refresh", icon:"st.secondary.refresh"
                }
                main(["alarmStatus"])
                details(["alarmStatus","away","stay","garageDoor","frontDoor","backDoor","livingRoomMotion","breakfastWindows","bedroom2Window","guestBathroomWindow","bedroom3Window","livingRoomWindows","masterBedroomWindows","officeWindows","diningWindows","chime","systemStatus","refresh","panic"])
        }
}



// Parse incoming device messages to generate events

def parse(String description) {

    log.debug description
    def stateToDisplay
    
    def msg = zigbee.parse(description)?.text
    log.debug "Received ${msg}"
    def result
    
    if (!msg || msg.trim() == "ping") {
        result = createEvent(name: null, value: msg)
//        update() 
    } else if ( msg.length() >= 4 ) {
        // Process ready update
        if ( msg.substring(0, 2) == "RD" ) {
            if (msg[3] == "0") {
                result = createEvent(name: "alarmStatus", value: "notready")
                // When status is "Not Ready" we cannot arm
                sendEvent(name: "awaySwitch", value: "off")
                sendEvent(name: "staySwitch", value: "off")
                sendEvent(name: "contact", value: "open")
                sendEvent(name: "response",  value: "alarmStatus notready", type: alarmStatus)
            }
            else {
                result = createEvent(name: "alarmStatus", value: "ready")
                // When status is "Ready" we can arm
                sendEvent(name: "awaySwitch", value: "off")
                sendEvent(name: "staySwitch", value: "off")
                sendEvent(name: "switch", value: "off")
                sendEvent(name: "panic", value: "off")
                sendEvent(name: "contact", value: "open")
                sendEvent(name: "systemStatus", value: "System Status:No events")
                sendEvent(name: "response",  value: "alarmStatus ready", type: alarmStatus)
            }
        // Process arm update
        } else if ( msg.substring(0, 2) == "AR" ) {
            if (msg[3] == "0") {
                result = createEvent(name: "alarmStatus", value: "disarmed") 
                sendEvent(name: "awaySwitch", value: "off")
                sendEvent(name: "staySwitch", value: "off")
                sendEvent(name: "switch", value: "off")
                sendEvent(name: "contact", value: "open")
                sendEvent(name: "response",  value: "alarmStatus disarmed", type: alarmStatus)
            }
            else if (msg[3] == "1") {
                if (msg[4] == "0" | msg[4] == "2") {
                    result = createEvent(name: "alarmStatus", value: "away")
                    sendEvent(name: "awaySwitch", value: "on")
                    sendEvent(name: "staySwitch", value: "off")
                    sendEvent(name: "switch", value: "on")
                    sendEvent(name: "contact", value: "closed")
                    sendEvent(name: "response",  value: "alarmStatus away", type: alarmStatus)
                }
                else if (msg[4] == "1" | msg[4] == "3") {
                    result = createEvent(name: "alarmStatus", value: "stay")
                    sendEvent(name: "awaySwitch", value: "off")
                    sendEvent(name: "staySwitch", value: "on")
                    sendEvent(name: "switch", value: "on")
                    sendEvent(name: "contact", value: "closed")
                    sendEvent(name: "response",  value: "alarmStatus stay", type: alarmStatus)
                }
            }
            else if (msg[3] == "2") {
                result = createEvent(name: "alarmStatus", value: "arming")
                sendEvent(name: "awaySwitch", value: "off")
                sendEvent(name: "staySwitch", value: "off")
                sendEvent(name: "switch", value: "on")
                sendEvent(name: "response",  value: "alarmStatus arming", type: alarmStatus)
            }
        } else if ( msg.substring(0, 2) == "SY" ) {
         // Process various system statuses
            if ( msg.substring(3, 6) == "658")  {
            
                result = createEvent(name: "systemStatus", value: "System Status\nKeypad Lockout")
            
            }
            else if ( msg.substring(3, 6) == "670")  {
            
                result = createEvent(name: "systemStatus", value: "System Status\nInvalid Access Code")
            
            }
            else if ( msg.substring(3, 6) == "672")  {
            
                result = createEvent(name: "systemStatus", value: "System Status\nFailed to arm")
            
            }
            else if ( msg.substring(3, 6) == "802")  {

                
                result = createEvent(name: "systemStatus", value: "System Status\nPanel AC Trouble")

            }
            else if ( msg.substring(3, 6) == "803")  {

                
                result = createEvent(name: "systemStatus", value: "System Status\nPanel AC Trouble Rest")

            }
            else if ( msg.substring(3, 6) == "806")  {

                
                result = createEvent(name: "systemStatus", value: "System Status\nSystem Bell Trouble")

            }
            else if ( msg.substring(3, 6) == "807")  {

                
                result = createEvent(name: "systemStatus", value: "System Status\nSystem Bell Trouble Rest")

            }
            else if ( msg.substring(3, 6) == "810")  {

                
                result = createEvent(name: "systemStatus", value: "System Status\nTLM line 1 Trouble")

            }
            else if ( msg.substring(3, 6) == "811")  {

                
                result = createEvent(name: "systemStatus", value: "System Status\nTLM line 1 Trouble Rest")

            }
            else if ( msg.substring(3, 6) == "812")  {

                
                result = createEvent(name: "systemStatus", value: "System Status\nTLM line 2 Trouble")

            }
            else if ( msg.substring(3, 6) == "813")  {

                
                result = createEvent(name: "systemStatus", value: "System Status\nTLM line 2 Trouble Rest")

            }
            else if ( msg.substring(3, 6) == "821")  {

                
                result = createEvent(name: "systemStatus", value: "System Status\nLow Battery at " + substring(6,3))

            }
            else if ( msg.substring(3, 6) == "822")  {

                
                result = createEvent(name: "systemStatus", value: "System Status\nLow Battery Rest at " + substring(6,3))

            }
            else if ( msg.substring(3, 6) == "829")  {

                result = createEvent(name: "systemStatus", value: "System Status\nSystem Tamper")

            }
            else if ( msg.substring(3, 6) == "830")  {

                result = createEvent(name: "systemStatus", value: "System Status\nSystem Tamper Rest")

            }
            else if ( msg.substring(3, 6) == "840")  {

                result = createEvent(name: "systemStatus", value: "System Status\nTrouble Status(LCD)")

            }
            else if ( msg.substring(3, 6) == "841")  {

                result = createEvent(name: "systemStatus", value: "System Status\nTrouble Status Rest")

            }
            else if ( msg.substring(3, 6) == "896")  {

                result = createEvent(name: "systemStatus", value: "System Status\nKeybus fault")

            }
            else if ( msg.substring(3, 6) == "897")  {

                result = createEvent(name: "systemStatus", value: "System Status\nKeybus Fault Rest")

            }
         
        // Process alarm update
        } else if ( msg.substring(0, 2) == "AL" ) {
            if (msg[3] == "1") {
                result = createEvent(name: "alarmStatus", value: "alarm")
                sendEvent(name: "response",  value: "alarmStatus alarm", type: alarmStatus)
            }
        // Process chime update
        } else if ( msg.substring(0, 2) == "CH" ) {
            if (msg[3] == "1") {
                result = createEvent(name: "chime", value: "chimeOn")
            } else {
                result = createEvent(name: "chime", value: "chimeOff")
            }    
        // Process zone update
        } else if ( msg.substring(0, 2) == "ZN" ) {
            if ( msg.substring(3, 9) == "609001" ){
                stateToDisplay = "GD open"
                result = createEvent(name: "garageDoor", value: stateToDisplay)
		// zone number below should match the one defined in ArduinoAlarmController
                sendEvent(name: "response",  value: "r 1 open", type: "Open/Closed Sensor")
            }
            else if ( msg.substring(3, 9) == "610001" ){
                stateToDisplay = "GD closed"
                result = createEvent(name: "garageDoor", value: stateToDisplay)
		// zone number below should match the one defined in ArduinoAlarmController
                sendEvent(name: "response",  value: "r 1 closed", type: "Open/Closed Sensor")  

            }
            else if ( msg.substring(3, 9) == "609002" ){
                stateToDisplay = "FD open"
                result = createEvent(name: "frontDoor", value: stateToDisplay)
		// zone number below should match the one defined in ArduinoAlarmController
                sendEvent(name: "response",  value: "r 2 open", type: "Open/Closed Sensor")
            }
            else if ( msg.substring(3, 9) == "610002" ){
                stateToDisplay = "FD closed"
                result = createEvent(name: "frontDoor", value: stateToDisplay)
		// zone number below should match the one defined in ArduinoAlarmController
                sendEvent(name: "response",  value: "r 2 closed", type: "Open/Closed Sensor") 
            }
            else if ( msg.substring(3, 9) == "609003" ){
                stateToDisplay = "BD open"
                result = createEvent(name: "backDoor", value: stateToDisplay)
		// zone number below should match the one defined in ArduinoAlarmController
                sendEvent(name: "response",  value: "r 3 open", type: "Open/Closed Sensor")            
            }
            else if ( msg.substring(3, 9) == "610003" ){
                stateToDisplay = "BD closed"
                result = createEvent(name: "backDoor", value: stateToDisplay)
		// zone number below should match the one defined in ArduinoAlarmController
                sendEvent(name: "response",  value: "r 3 closed", type: "Open/Closed Sensor")            
            }
            else if ( msg.substring(3, 9) == "609004" ){
                stateToDisplay = "LRM active"
                result = createEvent(name: "livingRoomMotion", value: stateToDisplay)
                sendEvent(name: "motion", value:  "active")
		// zone number below should match the one defined in ArduinoAlarmController
                sendEvent(name: "response",  value: "r 4 active", type: "Motion Detector")            
            }
            else if ( msg.substring(3, 9) == "610004" ){
                stateToDisplay = "LRM inactive"
                result = createEvent(name: "livingRoomMotion", value: stateToDisplay)
		// zone number below should match the one defined in ArduinoAlarmController
                sendEvent(name: "response",  value: "r 4 inactive", type: "Motion Detector")            
            }
            else if ( msg.substring(3, 9) == "609009" ){
                stateToDisplay = "BWin open"
                result = createEvent(name: "breakfastWindows", value: stateToDisplay)
		// zone number below should match the one defined in ArduinoAlarmController
                sendEvent(name: "response",  value: "r 9 open", type: "Open/Closed Sensor")            
            }
            else if ( msg.substring(3, 9) == "610009" ){
                stateToDisplay = "BWin closed"
                result = createEvent(name: "breakfastWindows", value: stateToDisplay)
		// zone number below should match the one defined in ArduinoAlarmController
                sendEvent(name: "response",  value: "r 9 closed", type: "Open/Closed Sensor")            
            }
            else if ( msg.substring(3, 9) == "609010" ){
                stateToDisplay = "B2Win open"
                result = createEvent(name: "bedroom2Window", value: stateToDisplay)
		// zone number below should match the one defined in ArduinoAlarmController
                sendEvent(name: "response",  value: "r 10 open", type: "Open/Closed Sensor")
            }
            else if ( msg.substring(3, 9) == "610010" ){
                stateToDisplay = "B2Win closed"
                result = createEvent(name: "bedroom2Window", value: stateToDisplay)
		// zone number below should match the one defined in ArduinoAlarmController
                sendEvent(name: "response",  value: "r 10 closed", type: "Open/Closed Sensor")
            }
            else if ( msg.substring(3, 9) == "609011" ){
                stateToDisplay = "GBWin open"
                result = createEvent(name: "guestBathroomWindow", value: stateToDisplay)
		// zone number below should match the one defined in ArduinoAlarmController
                sendEvent(name: "response",  value: "r 11 open", type: "Open/Closed Sensor")
            }
            else if ( msg.substring(3, 9) == "610011" ){
                stateToDisplay = "GBWin closed"
                result = createEvent(name: "guestBathroomWindow", value: stateToDisplay)
		// zone number below should match the one defined in ArduinoAlarmController
                sendEvent(name: "response",  value: "r 11 closed", type: "Open/Closed Sensor")
            }
            else if ( msg.substring(3, 9) == "609012" ){
                stateToDisplay = "B3Win open"
                result = createEvent(name: "bedroom3Window", value: stateToDisplay)
		// zone number below should match the one defined in ArduinoAlarmController
                sendEvent(name: "response",  value: "r 12 open", type: "Open/Closed Sensor")
            }
            else if ( msg.substring(3, 9) == "610012" ){
                stateToDisplay = "B3Win closed"
                result = createEvent(name: "bedroom3Window", value: stateToDisplay)
		// zone number below should match the one defined in ArduinoAlarmController
                sendEvent(name: "response",  value: "r 12 closed", type: "Open/Closed Sensor")
            }
            else if ( msg.substring(3, 9) == "609013" ){
                stateToDisplay = "LRWin open"
                result = createEvent(name: "livingRoomWindows", value: stateToDisplay)
		// zone number below should match the one defined in ArduinoAlarmController
                sendEvent(name: "response",  value: "r 13 open", type: "Open/Closed Sensor")
            }
            else if ( msg.substring(3, 9) == "610013" ){
                stateToDisplay = "LRWin closed"
                result = createEvent(name: "livingRoomWindows", value: stateToDisplay)
		// zone number below should match the one defined in ArduinoAlarmController
                sendEvent(name: "response",  value: "r 13 closed", type: "Open/Closed Sensor")
            }
            else if ( msg.substring(3, 9) == "609014" ){
                stateToDisplay = "MBWin open"
                result = createEvent(name: "masterBedroomWindows", value: stateToDisplay)
		// zone number below should match the one defined in ArduinoAlarmController
                sendEvent(name: "response",  value: "r 14 open", type: "Open/Closed Sensor")
            }
            else if ( msg.substring(3, 9) == "610014" ){
                stateToDisplay = "MBWin closed"
                result = createEvent(name: "masterBedroomWindows", value: stateToDisplay)
		// zone number below should match the one defined in ArduinoAlarmController
                sendEvent(name: "response",  value: "r 14 closed", type: "Open/Closed Sensor")
            }
            else if ( msg.substring(3, 9) == "609015" ){
                stateToDisplay = "OWin open"
                result = createEvent(name: "officeWindows", value: stateToDisplay)
		// zone number below should match the one defined in ArduinoAlarmController
                sendEvent(name: "response",  value: "r 15 open", type: "Open/Closed Sensor")
            }
            else if ( msg.substring(3, 9) == "610015" ){
                stateToDisplay = "OWin closed"
                result = createEvent(name: "officeWindows", value: stateToDisplay)
		// zone number below should match the one defined in ArduinoAlarmController
                sendEvent(name: "response",  value: "r 15 closed", type: "Open/Closed Sensor")
            }
            else if ( msg.substring(3, 9) == "609016" ){
                stateToDisplay = "DWin open"
                result = createEvent(name: "diningWindows", value: stateToDisplay)
		// zone number below should match the one defined in ArduinoAlarmController
                sendEvent(name: "response",  value: "r 16 open", type: "Open/Closed Sensor")
            }
            else if ( msg.substring(3, 9) == "610016" ){
                stateToDisplay = "DWin closed"
                result = createEvent(name: "diningWindows", value: stateToDisplay)
		// zone number below should match the one defined in ArduinoAlarmController
                sendEvent(name: "response",  value: "r 16 closed", type: "Open/Closed Sensor")
            }
            else {
                log.debug "Unhandled zone: " + msg
            }
        }
    }
    
    log.debug "Parse returned ${result?.descriptionText}"
    return result
}

// Implement "switch" (turn alarm on/off)
def on() {
    armStay()
}

def off() {
    disarm()
}


def away() {
    armAway()
}

// Commands sent to the device
def armAway() {
    log.debug "Sending arm command"
    zigbee.smartShield(text: "armAway").format()
}

def armStay() {
    log.debug "Sending arm command"
    zigbee.smartShield(text: "armStay").format()
}

def disarm() {
    log.debug "Sending disarm command"
    zigbee.smartShield(text: "disarm").format()
}

def strobe() {
    panic()
}

def siren() {
    panic()
} 

def both() {
    panic()
}

def chimeToggle() {
    log.debug "Toggling chime"
    zigbee.smartShield(text: "chimeOn").format()
}

def panic() {
    log.debug "Sending panic command"
    zigbee.smartShield(text: "panic").format()
}

// TODO: Need to send off, on, off with a few secs in between to stop and clear the alarm
def clear() {
    disarm()
}

def refresh() {
    update()
}

def update() {
    log.debug "Sending update command"
    zigbee.smartShield(text: "update").format()
}

def configure() {
    update()
}