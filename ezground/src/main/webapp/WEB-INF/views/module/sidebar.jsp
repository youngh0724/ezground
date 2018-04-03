
	<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
			

							<!-- Search -->
								<section id="search" class="alt">
									<form method="post" action="#">
										<input type="text" name="query" id="query" placeholder="Search" />
									</form>
								</section>

							<!-- Menu -->
								<nav id="menu">
									<header class="major">
										<h2>Menu</h2>
									</header>
									<ul>
										<li><a href="${pageContext.request.contextPath}/views/projectMember">������Ʈ ���</a></li>
										<li><a href="${pageContext.request.contextPath}/">Home</a></li>
										<li>
											<span class="opener">Facility</span>
											<ul>
												<li><a href="${pageContext.request.contextPath}/facility/facilityInsertForm">�ü� ���</a></li>
												<li><a href="${pageContext.request.contextPath}/facility/memberFacilityInsertStatusListForm">���� �ü� ��� ����</a></li>
											</ul>
										</li>
										<li>
											<span class="opener">TEAM</span>
											<ul>
												<li><a href="${pageContext.request.contextPath}/team/teamList">��ü �� ���</a></li>
												<li><a href="${pageContext.request.contextPath}/team/teamManagement">���� �� ����</a></li>												
											</ul>
										</li>										
										<li>
											<span class="opener">MATCH</span>
											<ul>
												<li><a href="${pageContext.request.contextPath}/creatMatch?entryNo=${currentSportEntry.getSportEntriesNo()}">��ġ ����</a></li>
												<li><a href="${pageContext.request.contextPath}/match/matchSelect">��ġ �˻�</a></li>																				
											</ul>
										</li>
										<li><a href="#">Maximus Erat</a></li>									
									</ul>
								</nav>

							<!-- Section -->
								<section>
									<header class="major">
										<h2>Ante interdum</h2>
									</header>
									<div class="mini-posts">
										<article>
											<a href="#" class="image"><img src="images/pic07.jpg" alt="" /></a>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.</p>
										</article>
										<article>
											<a href="#" class="image"><img src="images/pic08.jpg" alt="" /></a>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.</p>
										</article>
										<article>
											<a href="#" class="image"><img src="images/pic09.jpg" alt="" /></a>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.</p>
										</article>
									</div>
									<ul class="actions">
										<li><a href="#" class="button">More</a></li>
									</ul>
								</section>

							<!-- Section -->
								<section>
									<header class="major">
										<h2>Get in touch</h2>
									</header>
									<p>Sed varius enim lorem ullamcorper dolore aliquam aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin sed aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
									<ul class="contact">
										<li class="fa-envelope-o"><a href="#">information@untitled.tld</a></li>
										<li class="fa-phone">(000) 000-0000</li>
										<li class="fa-home">1234 Somewhere Road #8254<br />
										Nashville, TN 00000-0000</li>
									</ul>
								</section>
								
								<!-- Footer -->
								<footer id="footer">
									<p class="copyright">&copy; Untitled. All rights reserved. Demo Images: <a href="https://unsplash.com">Unsplash</a>. Design: <a href="https://html5up.net">HTML5 UP</a>.</p>
								</footer>
