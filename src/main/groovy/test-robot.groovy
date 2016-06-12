
import java.awt.AWTException
import java.awt.Robot
import java.awt.event.InputEvent
import java.awt.event.KeyEvent

import java.awt.Toolkit
import java.awt.datatransfer.Clipboard
import java.awt.datatransfer.StringSelection

long lastModifyHandled = 0

while(true){
	File f = new File('H:/script/test-robot-url.txt')
	long lastModify = f.lastModified()

	if(lastModifyHandled != lastModify){
		String url = f.text

		try{
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard()
			clipboard.setContents(new StringSelection(url), null)

			println 'copied ' + url

			Robot rb = new Robot()
			rb.keyPress(KeyEvent.VK_F10)
			rb.keyRelease(KeyEvent.VK_F10)

			println 'F10 clicked'
		}catch(Exception e){
			println 'queue handler error ' + url
			e.printStackTrace()
		}

		lastModifyHandled = lastModify
	}else{
		println 'file not change'
	}

	Thread.currentThread().sleep(1000 * 3)
}