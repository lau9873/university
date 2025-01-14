#include <stdio.h>
#include <stdlib.h>
#include <dirent.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <stdbool.h>
#include <pwd.h>
#include <grp.h>
#include <libc.h>
#define BUFFER_SIZE 1024


void imprimir_info(bool b,struct stat* info, char* nome){
    mode_t mode = (*info).st_mode;
    printf((b) ? "d" : "-");
    printf((mode & S_IRUSR) ? "r" : "-");
    printf((mode & S_IWUSR) ? "w" : "-");
    printf((mode & S_IXUSR) ? "x" : "-");
    printf((mode & S_IRGRP) ? "r" : "-");
    printf((mode & S_IWGRP) ? "w" : "-");
    printf((mode & S_IXGRP) ? "x" : "-");
    printf((mode & S_IROTH) ? "r" : "-");
    printf((mode & S_IWOTH) ? "w" : "-");
    printf((mode & S_IXOTH) ? "x  " : "-  ");
    char *temp = ctime(&(*info).st_mtime);
    temp[strcspn(temp, "\n")] = '\0';  // Substitui o '\n' por '\0'
    printf("%d %s  %s  %d %s %s\n",(*info).st_nlink, getpwuid((*info).st_uid)->pw_name, 
    getgrgid((*info).st_gid)->gr_name, (int)(*info).st_size,temp, nome);
}

int main(int argc, char** argv) {
  struct stat info;
  if (argc != 2) {
    fprintf (stderr, "usage: %s dirname\n", argv[0]);
    exit(EXIT_FAILURE);
  }
  if (stat(argv[1], &info) == -1) {
        fprintf (stderr,"cannot obtain info about: %s\n", argv[1]);
        exit(EXIT_FAILURE);
    }
  if (S_ISREG((info).st_mode)) {
        imprimir_info(false, &info, argv[1]);
    
    } 
    else if (S_ISDIR((info).st_mode)) {  
        printf("total %d\n", (int) (info).st_blocks);   
        DIR *q = opendir(argv[1]);
        if (q == NULL) {
            fprintf (stderr, "cannot open directory: %s\n", argv[1]);
            exit(EXIT_FAILURE);
        }
        struct dirent *p;
        while ((p = readdir(q)) != NULL) {
            //printf("%s\n",p->d_name);
            if (strcmp(p->d_name, ".") == 0 || strcmp(p->d_name, "..") == 0) {
                continue;
                }
            char path[BUFFER_SIZE];
            snprintf(path, BUFFER_SIZE, "%s/%s", argv[1], p->d_name);
            
            struct stat info2;
            int l = stat(path, &info2);
            if ((l == -1) || (!(S_ISDIR((info2).st_mode)) && !(S_ISREG((info2).st_mode)))) {
                //fprintf(stderr, "cannot obtain info about: %s\n", path);
                continue;
            }
            char *h=p->d_name;
            if (h[0]=='.'){
                continue;
            }
            imprimir_info(S_ISDIR((info2).st_mode),&info2,p->d_name);
        }
        closedir(q);
    }
        exit(EXIT_SUCCESS);
}