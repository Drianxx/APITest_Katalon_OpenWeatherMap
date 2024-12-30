import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

def response = WS.sendRequest(findTestObject('Weather Forecast'))

// Verifikasi status code
WS.verifyResponseStatusCode(response, 200)

// Parsing response body ke JSON
def jsonResponse = new groovy.json.JsonSlurper().parseText(response.getResponseBodyContent())

// Cek Body Tidak Null
assert jsonResponse != null : 'Response body is null'

assert jsonResponse.list != null : 'List data not found in response'

// Main
assert jsonResponse.list[0].main.temp != null : 'temp component is missing'

// Weather
assert jsonResponse.list[0].weather.id != null : 'id component is missing'

// Clouds
assert jsonResponse.list[0].clouds.all != null : 'all component is missing'

// Wind
assert jsonResponse.list[0].wind.speed != null : 'speed component is missing'

// Visibility
assert jsonResponse.list[0].visibility != null : 'visibility component is missing'

// Pop
assert jsonResponse.list[0].pop != null : 'pop component is missing'

// Sys
assert jsonResponse.list[0].sys.pod != null : 'pod component is missing'

