package com.rest.web.user;

//@RequiredArgsConstructor
//@Service
//public class CustomUserDetailService implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    @Cacheable(value = CacheKey.USER, key = "#userNo", unless = "#result == null")
//    public UserDetails loadUserByUsername(String userNo) {
//
//    	Optional<User> dto = userRepository.findById(Long.parseLong(userNo));
//
//    	if (!dto.isPresent()) { throw new UsernameNotFoundException(""); }
//
//    	return dto.get();
//    }
//}
