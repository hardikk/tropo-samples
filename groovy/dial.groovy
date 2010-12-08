// --------------------------------------------
// demonstration of calling out
// See http://www.tropo.com for more info
// --------------------------------------------

print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>$callFactory")
say("transferring to ")

// Place a phone number here
def phoneNo = 14075551212

def event = call("sip:${phoneNo}@10.6.63.201",
      [
      answerOnMedia: false,
      callerID:      "+14075551313",
      timeout:        60.3456,
      // Error in debugger if event.value.calleeId is used
      onAnswer:       { event-> log("******************** Answered from ") },
      onError:        { log("******************** oops , error *********************") },
      onTimeout:      { log("******************** timeout *********************") },
      onCallFailure:  { log("******************** call failed *********************") }
      ] )

if (event.choice == 'answer'){
  def newcall=event.value
  newcall.say("call to sip:" + phoneNo + "@10.6.63.201")
  newcall.say("This a dial test for Groovy on the Tropo platform.")
}
