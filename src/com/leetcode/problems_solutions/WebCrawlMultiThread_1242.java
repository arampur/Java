package com.leetcode.problems_solutions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

public class WebCrawlMultiThread_1242  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public List<String> crawl(String startUrl, HtmlParser htmlParser) {
	        String hostName = getHostName(startUrl);

	        List<String> res = new ArrayList<>();
	        Set<String> visited = new HashSet<>();
	        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
	        Deque<Future> tasks = new ArrayDeque<>();

	        queue.offer(startUrl);

	        ExecutorService executor = Executors.newFixedThreadPool(4, r -> {
	            Thread t = new Thread(r);
	            t.setDaemon(true);
	            return t;
	        });

	        while (true) {
	            String url = queue.poll();
	            if (url != null) {
	                if (getHostName(url).equals(hostName) && !visited.contains(url)) {
	                    res.add(url);
	                    visited.add(url);
	                    // Use a thread in thread pool to fetch new URLs and put them into the queue.
	                    tasks.add(executor.submit(() -> {
	                        List<String> newUrls = htmlParser.getUrls(url);
	                        for (String newUrl : newUrls) {
	                            queue.offer(newUrl);
	                        }
	                    }));
	                }
	            } else {
	                if (!tasks.isEmpty()) {
	                    // Wait for the next task to complete, which may supply new URLs into the queue.
	                    Future nextTask = tasks.poll();
	                    try {
	                        nextTask.get();
	                    } catch (Exception e) {}
	                } else {
	                    // Exit when all tasks are completed.
	                    break;
	                }
	            }
	        }
	        return res;
	    }
	    
	    private String getHostName(String url) {
	        url = url.substring(7);
	        String[] parts = url.split("/");
	        return parts[0];
	    }

}
