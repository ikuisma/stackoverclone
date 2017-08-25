package wad.stackoverclone.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import wad.stackoverclone.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

    Account findAccountByUsername(String username);

}
