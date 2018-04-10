<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
			

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
										<li><a href="${pageContext.request.contextPath}/views/projectMember">프로젝트 멤버</a></li>
										<li><a href="${pageContext.request.contextPath}/">Home</a></li>	
										<li>
											<span class="opener">LOGIN</span>
											<ul>
												<li><a href="${pageContext.request.contextPath}/login">로그인</a></li>
												<li><a href="${pageContext.request.contextPath}/login/logout">로그아웃</a></li>												
											</ul>
										</li>									
										<li>
											<span class="opener">시설 이용</span>
											<ul>
												<li><a href="${pageContext.request.contextPath}/facility/facilityFieldList">예약 하기</a></li>
												<li><a href="${pageContext.request.contextPath}/facility/facilityInsertForm">시설 등록</a></li>
												<li><a href="${pageContext.request.contextPath}/facility/memberFacilityInsertStatusListForm">사업자 시설 등록 내역</a></li>
												<li><a href="${pageContext.request.contextPath}/facility/facilityFieldInsertListForm">구장 등록가능 리스트</a></li>
												<li><a href="${pageContext.request.contextPath}/facility/facilityAndFieldListForm">시설 And 구장 리스트</a></li>
												<li><a href="${pageContext.request.contextPath}/facility/facilityCalendarForm">시설 일정</a></li>
												
											</ul>
										</li>
										<li>
											<span class="opener">팀</span>
											<ul>
												<li><a href="${pageContext.request.contextPath}/team/teamList">전체 팀 목록</a></li>
												<li><a href="${pageContext.request.contextPath}/team/teamManagement">나의 팀 관리</a></li>												
											</ul>
										</li>										
										<li>
											<span class="opener">매치</span>
											<ul>
												<li><a href="${pageContext.request.contextPath}/creatMatch?entryNo=${currentSportEntry.getSportEntriesNo()}">매치 생성</a></li>
												<li><a href="${pageContext.request.contextPath}/match/matchSelect">매치 검색</a></li>																				
											</ul>
										</li>
										<li>
											<span class="opener">게시판</span>
											<ul>
												<li><a href="#">공지사항</a></li>
												<li><a href="#">자유게시판</a></li>
												<li><a href="#">매치게시판</a></li>																				
											</ul>
										</li>										
										<li><a href="#">MYPAGE</a></li>																	
									</ul>
								</nav>

							<!-- Section -->
								<section>
									<header class="major">
										<h2>Ante interdum</h2>
									</header>
									<div class="mini-posts">
										<article>
											<a href="#" class="image"><img src="./resources/images/pic07.jpg" alt="" /></a>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.</p>
										</article>
										<article>
											<a href="#" class="image"><img src="./resources/images/pic08.jpg" alt="" /></a>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.</p>
										</article>
										<article>
											<a href="#" class="image"><img src="./resources/images/pic09.jpg" alt="" /></a>
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
