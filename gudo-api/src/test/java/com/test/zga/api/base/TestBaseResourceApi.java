package com.test.zga.api.base;


import com.test.zga.api.common.BaseUnitTest;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Kevin.chen
 * @Description:
 * @Datetime: 2017-12-28 15:21
 */
public class TestBaseResourceApi extends BaseUnitTest {

   /* private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private BaseResourceApi baseResourceApi;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(baseResourceApi).build();
    }

    @Test
    public void testAdd() throws IOException {
        String userId = "1";
        String userName = "邓海波";
        String userAge = "12";
        UserEntity user = new UserEntity();
        user.setId(userId);
        user.setName(userName);
        user.setAge(userAge);

        when(userService.addUser(user)).thenReturn(1);

        Response response = baseResourceApi.AddUser(user);

        verify(userService).addUser(user);
    }


    @Test
    public void testGetUserInfo() throws Exception {
        String userId = "1";
        String userName = "邓海波";
        String userAge = "12";

        UserEntity user = new UserEntity();
        user.setId(userId);
        user.setName(userName);
        user.setAge(userAge);
       // when(userService.findOneUser(userId)).thenReturn(user);

        mockMvc.perform(get("/gudo/api/base/getUser"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(userId))
                .andExpect(jsonPath("name").value(userName));

    }*/
}
