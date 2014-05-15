package teich.flicker;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;

public class DownloadFlickerFeedThreadTest {

	@Test
	public void testCallsLoadImages() {
		FlickerFeedFrame frame = Mockito.mock(FlickerFeedFrame.class);
		DownloadFlickerFeedThread thread = new DownloadFlickerFeedThread(frame);

		VerificationMode never = Mockito.never();
		Mockito.verify(frame, never).loadImages(Mockito.any(FlickerFeed.class));

		thread.run();// wanna execute this code in the same thread tht test is
						// currently running

		VerificationMode once = Mockito.times(1);
		Mockito.verify(frame, once).loadImages(Mockito.any(FlickerFeed.class));// verify
																				// tht
																				// clld
																				// method
																				// once

	}

}
