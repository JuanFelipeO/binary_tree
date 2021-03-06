package com.binary_tree.binary_tree.controller;

import com.binary_tree.binary_tree.application.dto.ResponseBinaryTreeDto;
import com.binary_tree.binary_tree.exception.BinaryTreeException;
import com.binary_tree.binary_tree.exception.DataNotFoundException;
import com.binary_tree.binary_tree.model.Boy;
import com.binary_tree.binary_tree.model.Node;
import com.binary_tree.binary_tree.service.BinaryTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Path;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "binarytree")
@Validated
@CrossOrigin("*")
public class BinaryTreeController {

    @Autowired
    private BinaryTreeService binaryTreeService;

    @PostMapping("/add")
    public @ResponseBody
    ResponseEntity<?> addBoy(@Valid @RequestBody Boy boy) throws BinaryTreeException
    {
        return binaryTreeService.addBoy(boy);
    }

    @GetMapping("/preorder")
    public @ResponseBody
    ResponseEntity<?> listBoysPreOrden() throws BinaryTreeException
    {
        return binaryTreeService.listBoys(1);
    }

    @GetMapping("/inorder")
    public @ResponseBody
    ResponseEntity<?> listBoysInOrden() throws BinaryTreeException
    {
        return binaryTreeService.listBoys(2);
    }

    @GetMapping("/postorder")
    public @ResponseBody
    ResponseEntity<?> listBoysPostOrden() throws BinaryTreeException
    {
        return binaryTreeService.listBoys(3);
    }

    @GetMapping("/count")
    public @ResponseBody
    ResponseEntity<?> countBinaryTree() throws BinaryTreeException
    {
        return binaryTreeService.count();
    }

    @GetMapping("/countnumber")
    public @ResponseBody
    ResponseEntity<?> counterEqualNum(Path.Node node, int number) throws BinaryTreeException
    {
        return binaryTreeService.counterEqualNum((Node) node,number);
    }

    @GetMapping("/listNum")
    public @ResponseBody
    ResponseEntity<?> listEqualNum(int number) throws DataNotFoundException
    {
        return binaryTreeService.listEqualNum(number);
    }

    @GetMapping("/listLeaves")
    public @ResponseBody
    ResponseEntity<?> listLeaf() throws BinaryTreeException
    {
        return binaryTreeService.listGetLeafs();
    }

    @PostMapping("/test/{cat1}")
    public @ResponseBody ResponseEntity<ResponseBinaryTreeDto> testCommunication(@PathVariable String cat1)
    {
        return new ResponseEntity<ResponseBinaryTreeDto>(
                new ResponseBinaryTreeDto("Hola "+cat1, "SATISFACTORIA", null), HttpStatus.OK);
    }
}