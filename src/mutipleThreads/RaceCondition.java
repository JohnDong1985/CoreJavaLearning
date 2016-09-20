package mutipleThreads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;


public class RaceCondition {

	private static Map cachedMap = new HashMap(7000);
	private static Boolean firstInvoke = true;

	// Thread 1
	public void getMyValue() {
		int i = 0;
		if (firstInvoke) {
			while (i < 7000) {

				cachedMap.put("new", "newValue");
				i++;
			}
			firstInvoke = false;
		}
	}

	// Thread 2
	// cachedMap.get("new");

	//同时满足SMP友好，及性能最佳的
	//为了确保SMP状态下性能最优，我们在某一些关键地方也用到了上面的CAS+spinning的技巧。
	private AtomicBoolean firstInvokeBest = new AtomicBoolean(true);

	public void getMyValue2() {
		for (;;) {

			Boolean current = firstInvokeBest.get();

			if (!current) { // the most likely condition branch, see
							// http://pt.alibaba-inc.com/wp/dev_related/optimization_363/likely-unlikely.html

				break;

			}

			if (firstInvokeBest.compareAndSet(current, false)) {

				// Then load data…

				break;

			}
		}
	}
	
	
}
