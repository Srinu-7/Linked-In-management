package LinkedInManagementSystem.example.LinkedInManagement.Contoller;

import LinkedInManagementSystem.example.LinkedInManagement.SeriveLayer.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/follow")
public class FollowController {

    @Autowired
    private FollowService followService;

    @PutMapping("/followSomeone")
    private ResponseEntity follow(@RequestParam ("userId") Integer userId,
                                  @RequestParam ("followerId") Integer followerId) throws Exception{
      try {
          followService.follow(userId , followerId);
         return new ResponseEntity("added",HttpStatus.OK);
      }catch ( Exception e){
         return new ResponseEntity(e.getMessage() , HttpStatus.BAD_REQUEST);
      }
    }

    @GetMapping("/followersList")
    private ResponseEntity FriendsToFollowSpecificPerson(@RequestParam("id") int id){

        try{
            List<Integer> friendsList = followService.FriendsToFollowSpecificPerson(id);
            return new ResponseEntity(friendsList,HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
